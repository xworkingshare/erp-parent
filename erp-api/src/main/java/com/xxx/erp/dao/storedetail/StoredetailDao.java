package com.xxx.erp.dao.storedetail;

import com.xxx.erp.bean.storedetail.Storedetail;
import com.xxx.erp.bean.storedetail.StoredetailQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoredetailDao {
    int countByExample(StoredetailQuery example);

    int deleteByExample(StoredetailQuery example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Storedetail record);

    int insertSelective(Storedetail record);

    List<Storedetail> selectByExample(StoredetailQuery example);

    Storedetail selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Storedetail record, @Param("example") StoredetailQuery example);

    int updateByExample(@Param("record") Storedetail record, @Param("example") StoredetailQuery example);

    int updateByPrimaryKeySelective(Storedetail record);

    int updateByPrimaryKey(Storedetail record);
}