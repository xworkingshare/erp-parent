package com.xxx.erp.controller.orderdetail;

import com.xxx.erp.bean.orderdetail.Orderdetail;
import com.xxx.erp.bean.orderdetail.OrderdetailQuery;
import com.xxx.erp.common.commonbean.CommonResultListBean;
import com.xxx.erp.common.commonbean.orderdetail.OrderdetailParam;
import com.xxx.erp.common.util.JackSonUtils;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.orderdetail.IOrderdetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: OrderdetailController
 * @Description: 订单明细=订单项操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  0:38
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/orderdetail")
public class OrderdetailController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrderdetailController.class);

    @Autowired
    IOrderdetailService orderdetailService;


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

        Orderdetail orderdetail = orderdetailService.get(id);


        return orderdetail;
    }

    /**
     *@MethodName： getListByPage
     *@Description： 按条件/ 不按条件，分页列表查询
     *@Params：[orderdetailParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:40
     *@Version： 1.0
     */
    @PostMapping(value = "/getlistByPage", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getListByPage(OrderdetailParam orderdetailParam) throws Exception {

        OrderdetailQuery orderdetailQuery = convertFromParamToBeanQuery(orderdetailParam);

        //按条件，查询列表
        List<Orderdetail> orderdetailList = orderdetailService.getList(orderdetailQuery);
        //按条件，查询总条数
        long count = orderdetailService.getCount(orderdetailQuery);

        //封装：结果列表 + 结果总条数
        CommonResultListBean<Orderdetail> orderdetailCommonResultListBean = new CommonResultListBean<>(orderdetailList, count);

        return orderdetailCommonResultListBean;
    }


    /**
     *@MethodName： getlistAll
     *@Description： 无条件、无分页，全表列表查询
     *@Params：[orderdetailParam]
     *@ParamComment：
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:40
     *@Version： 1.0
     */
    @PostMapping(value = "/getlistAll", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getlistAll(OrderdetailParam orderdetailParam) throws Exception {

        OrderdetailQuery orderdetailQuery = convertFromParamToBeanQuery(orderdetailParam);

        //按条件，查询列表
        List<Orderdetail> orderdetailList = orderdetailService.getList(orderdetailQuery);


        return JackSonUtils.objectToJson(orderdetailList);
    }

    /**
     *@MethodName： getAllForCombobox
     *@Description：  查询所欲订单明细=订单项信息，给下拉框使用
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

        List<Orderdetail> list = orderdetailService.getList(new OrderdetailQuery());

        return list;
    }
    

    /**
     *@MethodName： addOne
     *@Description： 新增1个对象
     *@Params：[orderdetailParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:59
     *@Version： 1.0
     */
    @PostMapping(value = "/addOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object addOne(OrderdetailParam orderdetailParam)throws  Exception{

        start();
        if(null!=orderdetailParam){
            int affectRows = orderdetailService.add(orderdetailParam);
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


    /**
     *@MethodName： upateOne
     *@Description： 修改单个对象
     *@Params：[orderdetailParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:01
     *@Version： 1.0
     */
    @PostMapping(value = "/updateOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object upateOne(OrderdetailParam orderdetailParam) throws Exception{

        start();
        if(null!=orderdetailParam){
            int affectRows = orderdetailService.update(orderdetailParam);
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
     *@Params：[orderdetailParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:23
     *@Version： 1.0
     */
    @PostMapping(value = "/deleteOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object deleteOne(OrderdetailParam orderdetailParam) throws Exception{

        start();
        if(null!=orderdetailParam){
            int affectRows = orderdetailService.delete(orderdetailParam.getUuid());
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
     *@Params：[orderdetailParam]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.orderdetail.OrderdetailQuery
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  15:01
     *@Version： 1.0
     */
    private OrderdetailQuery convertFromParamToBeanQuery(OrderdetailParam orderdetailParam) throws Exception {
        OrderdetailQuery orderdetailQuery = new OrderdetailQuery();

        //封装分页参数
        if(0!=orderdetailParam.getPage() && 0!=orderdetailParam.getRows()){
            orderdetailQuery.setPageSize(orderdetailParam.getRows());
            orderdetailQuery.setPageNo(orderdetailParam.getPage());

        }

        //封装查询参数
        OrderdetailQuery.Criteria orderdetailQueryCriteria = orderdetailQuery.createCriteria();
        if(null!=orderdetailParam){

            if (null!=orderdetailParam.getUuid()){
                orderdetailQueryCriteria.andUuidEqualTo(orderdetailParam.getUuid());

            }
            if(null!=orderdetailParam.getOrderuuid()){
                orderdetailQueryCriteria.andOrderuuidEqualTo(orderdetailParam.getOrderuuid());

            }

        }

        return orderdetailQuery;
    }


}
