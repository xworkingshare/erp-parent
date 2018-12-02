package com.xxx.erp.dao.supplier;

import com.xxx.erp.bean.supplier.Supplier;
import com.xxx.erp.bean.supplier.SupplierQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierDao {
    int countByExample(SupplierQuery example);

    int deleteByExample(SupplierQuery example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierQuery example);

    Supplier selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierQuery example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierQuery example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}