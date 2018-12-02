package com.xxx.erp.dao.storeoper;

import com.xxx.erp.bean.storeoper.Storeoper;
import com.xxx.erp.bean.storeoper.StoreoperQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreoperDao {
    int countByExample(StoreoperQuery example);

    int deleteByExample(StoreoperQuery example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Storeoper record);

    int insertSelective(Storeoper record);

    List<Storeoper> selectByExample(StoreoperQuery example);

    Storeoper selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Storeoper record, @Param("example") StoreoperQuery example);

    int updateByExample(@Param("record") Storeoper record, @Param("example") StoreoperQuery example);

    int updateByPrimaryKeySelective(Storeoper record);

    int updateByPrimaryKey(Storeoper record);
}