package com.xxx.erp.dao.emp;

import com.xxx.erp.bean.emp.Emp;
import com.xxx.erp.bean.emp.EmpQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpDao {
    int countByExample(EmpQuery example);

    int deleteByExample(EmpQuery example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpQuery example);

    Emp selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpQuery example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpQuery example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}