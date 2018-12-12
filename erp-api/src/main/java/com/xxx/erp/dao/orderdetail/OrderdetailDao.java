package com.xxx.erp.dao.orderdetail;

import com.xxx.erp.bean.orderdetail.Orderdetail;
import com.xxx.erp.bean.orderdetail.OrderdetailQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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


    /**
     *@MethodName： insertBatch
     *@Description：  批量插入 orderdetail
     *@Params：[orderdetails]
     *@ParamComment： 
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/12  20:34
     *@Version： 1.0
     */
    int insertBatch(List<Orderdetail> orderdetails);
}