package com.xxx.erp.dao.store;

import com.xxx.erp.bean.store.Store;
import com.xxx.erp.bean.store.StoreQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreDao {
    int countByExample(StoreQuery example);

    int deleteByExample(StoreQuery example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample(StoreQuery example);

    Store selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreQuery example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreQuery example);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}