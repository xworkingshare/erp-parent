package com.xxx.erp.dao.dep;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.bean.dep.DepQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepDao {
    int countByExample(DepQuery example);

    int deleteByExample(DepQuery example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Dep record);

    int insertSelective(Dep record);

    List<Dep> selectByExample(DepQuery example);

    Dep selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Dep record, @Param("example") DepQuery example);

    int updateByExample(@Param("record") Dep record, @Param("example") DepQuery example);

    int updateByPrimaryKeySelective(Dep record);

    int updateByPrimaryKey(Dep record);
}