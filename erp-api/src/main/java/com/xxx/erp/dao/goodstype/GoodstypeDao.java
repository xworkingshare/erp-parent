package com.xxx.erp.dao.goodstype;

import com.xxx.erp.bean.goodstype.Goodstype;
import com.xxx.erp.bean.goodstype.GoodstypeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodstypeDao {
    int countByExample(GoodstypeQuery example);

    int deleteByExample(GoodstypeQuery example);

    int deleteByPrimaryKey(Long uuid);

    int insert(Goodstype record);

    int insertSelective(Goodstype record);

    List<Goodstype> selectByExample(GoodstypeQuery example);

    Goodstype selectByPrimaryKey(Long uuid);

    int updateByExampleSelective(@Param("record") Goodstype record, @Param("example") GoodstypeQuery example);

    int updateByExample(@Param("record") Goodstype record, @Param("example") GoodstypeQuery example);

    int updateByPrimaryKeySelective(Goodstype record);

    int updateByPrimaryKey(Goodstype record);
}