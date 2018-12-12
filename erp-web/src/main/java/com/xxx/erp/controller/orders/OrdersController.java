package com.xxx.erp.controller.orders;

import com.xxx.erp.bean.emp.Emp;
import com.xxx.erp.bean.orderdetail.Orderdetail;
import com.xxx.erp.bean.orders.Orders;
import com.xxx.erp.bean.orders.OrdersQuery;
import com.xxx.erp.common.commonbean.CommonResultListBean;
import com.xxx.erp.common.commonbean.orders.OrdersParam;
import com.xxx.erp.common.constant.ConstantData;
import com.xxx.erp.common.util.JackSonUtils;
import com.xxx.erp.common.web.session.ISessionProvider;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.orderdetail.IOrderdetailService;
import com.xxx.erp.service.orders.IOrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: OrdersController
 * @Description: 订单操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  0:38
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    IOrdersService ordersService;
    @Autowired
    IOrderdetailService orderdetailService;
    @Autowired
    ISessionProvider sessionProvider;


    /**
     * @MethodName： getOneById
     * @Description： 根据id，查询单个对象，用于修改框展示
     * @Params：[id]
     * @ParamComment：
     * @Return：java.util.Map<java.lang.String,java.lang.Object>
     * @Author ：谢万清
     * @CreateTime ：2018/12/8  0:48
     * @Version： 1.0
     */
    @GetMapping("/getOneById")
    @ResponseBody
    public Object getOneById(Long id) throws Exception {

        Orders orders = ordersService.get(id);


        return orders;
    }

    /**
     *@MethodName： getListByPage
     *@Description： 按条件/ 不按条件，分页列表查询
     *@Params：[ordersParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:40
     *@Version： 1.0
     */
    @PostMapping(value = "/getlistByPage", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getListByPage(OrdersParam ordersParam) throws Exception {

        OrdersQuery ordersQuery = convertFromParamToBeanQuery(ordersParam);

        //按条件，查询列表
        List<Orders> ordersList = ordersService.getList(ordersQuery);
        //按条件，查询总条数
        long count = ordersService.getCount(ordersQuery);

        //封装：结果列表 + 结果总条数
        CommonResultListBean<Orders> ordersCommonResultListBean = new CommonResultListBean<>(ordersList, count);

        return ordersCommonResultListBean;
    }


    /**
     *@MethodName： getAllForCombobox
     *@Description：  查询所有订单信息，给下拉框使用
     *@Params：[]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  19:06
     *@Version： 1.0
     */
    @PostMapping(value = "/getAllForCombobox", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object  getAllForCombobox() throws  Exception{

        List<Orders> list = ordersService.getList(new OrdersQuery());

        return list;
    }
    

    /**
     *@MethodName： addOne
     *@Description： 新增1个对象
     *@Params：[ordersParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:59
     *@Version： 1.0
     */
    @PostMapping(value = "/addOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object addOne(Orders orders, String supplierUuid, String  orderdetailsJsonString,
                         HttpServletRequest request, HttpServletResponse response)throws
        Exception{

        start();
        if(null!=orders && !StringUtils.isEmpty(supplierUuid)){

            //给OrderParam设置，供应商的uuid
            orders.setSupplieruuid(Long.parseLong(supplierUuid));

            //给OrderParam设置，当前session中的emp为该订单的创建者
            String empString = sessionProvider.getAttribute(request, response, ConstantData.SESSION_EMP);
            Emp emp = JackSonUtils.jsonToPojo(empString, Emp.class);
            orders.setCreater(emp.getUuid());

            //给OrderParam设置，订单的创建时间
            orders.setCreatetime(new Date());

            //给OrderParam设置，订单的状态为：0，未审核状态
            orders.setState("0");

            //给OrderParam设置，订单编号orderNum
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
            String currentDate= sdf.format(new Date());
            Integer maxOrderNum = ordersService.getMaxOrderNum(currentDate);
            String orderNum="";
            if(maxOrderNum!=null ){
                orderNum= String.valueOf((maxOrderNum)+1);
            }else
            {
                orderNum=	currentDate+"00001";	//表示：当天第一笔订单
            }
            orders.setOrdernum(orderNum);


            //给所有的Orderdetail对象设置，所属订单号，并计算订单总数和订单总金额
            int num=0;//总数量
            double money=0;//总金额
            List<Orderdetail> orderdetails = JackSonUtils.jsonToList(orderdetailsJsonString, Orderdetail.class);
            for (Orderdetail orderdetail : orderdetails) {
                orderdetail.setState(orders.getState());
                num+=orderdetail.getNum();
                money+=orderdetail.getMoney();
            }
            orders.setTotalnum(num);
            orders.setTotalprice(money);

            //插入订单和订单项目
            boolean flag = ordersService.insertOrdersAndOrderdetail(orders, orderdetails);


            if(flag){
                isSuccess(true);

            }else {
                isSuccess(false);
            }
        }else {
            isSuccess(false);
        }

        return endGetMap();
    }



    /**
     *@MethodName： upateOne
     *@Description： 修改单个对象
     *@Params：[ordersParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:01
     *@Version： 1.0
     */
    @PostMapping(value = "/updateOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object upateOne(OrdersParam ordersParam) throws Exception{

        start();
        if(null!=ordersParam){
            int affectRows = ordersService.update(ordersParam);
            if(affectRows > 0){
                isSuccess(true);

            }else {
                isSuccess(false);
            }
        }else {
            isSuccess(false);
        }

        return endGetMap();
    }


    /***
     *@MethodName： deleteOne
     *@Description： 删除单个对象
     *@Params：[ordersParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:23
     *@Version： 1.0
     */
    @PostMapping(value = "/deleteOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object deleteOne(OrdersParam ordersParam) throws Exception{

        start();
        if(null!=ordersParam){
            int affectRows = ordersService.delete(ordersParam.getUuid());
            if(affectRows > 0){
                isSuccess(true);

            }else {
                isSuccess(false);
            }
        }else {
            isSuccess(false);
        }

        return endGetMap();

    }


    /***
     *@MethodName： convertFromParamToBeanQuery
     *@Description：   将 查询参数，封装到 xxxQuery对象中
     *@Params：[ordersParam]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.orders.OrdersQuery
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  15:01
     *@Version： 1.0
     */
    private OrdersQuery convertFromParamToBeanQuery(OrdersParam ordersParam) throws Exception {
        OrdersQuery ordersQuery = new OrdersQuery();

        //封装分页参数
        if(0!=ordersParam.getPage() && 0!=ordersParam.getRows()){
            ordersQuery.setPageSize(ordersParam.getRows());
            ordersQuery.setPageNo(ordersParam.getPage());

        }

        //封装查询参数
        OrdersQuery.Criteria ordersQueryCriteria = ordersQuery.createCriteria();
        if(null!=ordersParam){

            if (null!=ordersParam.getOrdernum()){
                ordersQueryCriteria.andOrdernumLike("%"+ordersParam.getOrdernum()+"%");

            }
            if(null!=ordersParam.getState()){
                ordersQueryCriteria.andStateEqualTo(ordersParam.getState());

            }

        }

        return ordersQuery;
    }


}
