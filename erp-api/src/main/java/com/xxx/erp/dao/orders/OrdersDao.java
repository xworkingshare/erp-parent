package com.xxx.erp.dao.orders;

import com.xxx.erp.bean.orders.Orders;
import com.xxx.erp.bean.orders.OrdersQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersDao {
    int countByExample(OrdersQuery example);

    int deleteByExample(OrdersQuery example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersQuery example);

    Orders selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersQuery example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersQuery example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);


    /**
     *@MethodName： selectMaxOrderNum
     *@Description： 获取 当前订单表中，最大订单号
     *@Params：[]
     *@ParamComment：
     *@Return：java.lang.String
     *@Author ：谢万清
     *@CreateTime ：2018/12/12  20:16
     *@Version： 1.0
     */
    Integer  selectMaxOrderNum(@Param("currentDate") String currentDate);
}