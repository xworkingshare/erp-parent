package com.xxx.erp.dao.emp_role;

import com.xxx.erp.bean.emp_role.EmpRoleKey;
import com.xxx.erp.bean.emp_role.EmpRoleQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpRoleDao {
    int countByExample(EmpRoleQuery example);

    int deleteByExample(EmpRoleQuery example);

    int deleteByPrimaryKey(EmpRoleKey key);

    int insert(EmpRoleKey record);

    int insertSelective(EmpRoleKey record);

    List<EmpRoleKey> selectByExample(EmpRoleQuery example);

    int updateByExampleSelective(@Param("record") EmpRoleKey record, @Param("example") EmpRoleQuery example);

    int updateByExample(@Param("record") EmpRoleKey record, @Param("example") EmpRoleQuery example);
}