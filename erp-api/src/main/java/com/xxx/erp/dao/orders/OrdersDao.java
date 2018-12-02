package com.xxx.erp.dao.orders;

import com.xxx.erp.bean.orders.Orders;
import com.xxx.erp.bean.orders.OrdersQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}