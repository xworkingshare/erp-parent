package com.xxx.erp.service.orders;

import com.xxx.erp.bean.orderdetail.Orderdetail;
import com.xxx.erp.bean.orders.Orders;
import com.xxx.erp.bean.orders.OrdersQuery;

import java.util.List;

/**
 * @ClassName: OrdersService
 * @Description: 订单Service层接口
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  2:56
 * @Version: 1.0
 **/
public interface IOrdersService {

    /**
     *@MethodName： getList
     *@Description： 根据条件，查询对象列表
     *@Params：[ordersQuery]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.orders.Orders>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Orders> getList(OrdersQuery ordersQuery) throws  Exception;

    /**
     *@MethodName： getListByPage
     *@Description： 根据条件 ，查询分页对象
     *@Params：[ordersQuery, pageNo, pageSize]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.orders.Orders>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Orders> getListByPage(OrdersQuery ordersQuery, int pageNo, int pageSize) throws  Exception;

    /**
     *@MethodName： getCount
     *@Description： genuine条件 ，查询count统计值
     *@Params：[ordersQuery]
     *@ParamComment：
     *@Return：long
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public long getCount(OrdersQuery ordersQuery) throws  Exception;

    /**
     *@MethodName： add
     *@Description： 插入 单个对象
     *@Params：[orders]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int add(Orders orders) throws  Exception;

    /**
     *@MethodName： update
     *@Description： 更新 单个对象
     *@Params：[orders]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int update(Orders orders) throws  Exception;

    /**
     *@MethodName： delete
     *@Description： 根据  id ，删除单个对象
     *@Params：[id]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int delete(Long id) throws  Exception;

    /**
     *@MethodName： get
     *@Description： 根据 id ，查询单个对象
     *@Params：[id]
     *@ParamComment：
     *@Return：com.xxx.erp.bean.orders.Orders
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:52
     *@Version： 1.0
     */
    public Orders get(Long id) throws  Exception;


    /**
     *@MethodName： getMaxOrderNum
     *@Description： 获取 当前订单表中，最大订单号
     *@Params：[]
     *@ParamComment：
     *@Return：java.lang.String
     *@Author ：谢万清
     *@CreateTime ：2018/12/12  20:16
     *@Version： 1.0
     */
    Integer  getMaxOrderNum(String currentDate);



    /***
     *@MethodName： insertOrdersAndOrderdetail
     *@Description： 插入订单 和订单项
     *@Params：[ordersParam, orderdetails]
     *@ParamComment： 
     *@Return：boolean
     *@Author ：谢万清
     *@CreateTime ：2018/12/12  21:03
     *@Version： 1.0
     */
    boolean insertOrdersAndOrderdetail(Orders orders, List<Orderdetail> orderdetails) throws Exception;

}
