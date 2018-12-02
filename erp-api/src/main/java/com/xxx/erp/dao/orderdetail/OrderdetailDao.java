package com.xxx.erp.dao.orderdetail;

import com.xxx.erp.bean.orderdetail.Orderdetail;
import com.xxx.erp.bean.orderdetail.OrderdetailQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderdetailDao {
    int countByExample(OrderdetailQuery example);

    int deleteByExample(OrderdetailQuery example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailQuery example);

    Orderdetail selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailQuery example);

    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailQuery example);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}