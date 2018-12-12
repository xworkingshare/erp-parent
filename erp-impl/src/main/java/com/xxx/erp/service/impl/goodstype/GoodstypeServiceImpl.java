package com.xxx.erp.service.impl.goodstype;

import com.xxx.erp.bean.goodstype.Goodstype;
import com.xxx.erp.bean.goodstype.GoodstypeQuery;
import com.xxx.erp.dao.goodstype.GoodstypeDao;
import com.xxx.erp.service.goodstype.IGoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: GoodstypeServiceImpl
 * @Description: 商品类型管理 Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  15:00
 * @Version: 1.0
 **/
@Service
@Transactional
public class GoodstypeServiceImpl implements IGoodstypeService {


    @Autowired
    GoodstypeDao goodstypeDao;

    @Override
    public List<Goodstype> getList(GoodstypeQuery goodstypeQuery) {
        List<Goodstype> goodstypeList = goodstypeDao.selectByExample(goodstypeQuery);
        return goodstypeList;
    }


    @Override
    public List<Goodstype> getListByPage(GoodstypeQuery goodstypeQuery, int pageNo, int pageSize) {
        goodstypeQuery.setPageNo(pageNo);
        goodstypeQuery.setPageSize(pageSize);
        List<Goodstype> goodstypeList = goodstypeDao.selectByExample(goodstypeQuery);
        return goodstypeList;
    }

    @Override
    public long getCount(GoodstypeQuery goodstypeQuery) {
        int countResults= goodstypeDao.countByExample(goodstypeQuery);
        return countResults;
    }

    @Override
    public int add(Goodstype goodstype) {
        int affcetRows = goodstypeDao.insertSelective(goodstype);
        return affcetRows;
    }

    @Override
    public int update(Goodstype goodstype) {
        int affectRows = goodstypeDao.updateByPrimaryKeySelective(goodstype);
        return affectRows;
    }

    @Override
    public int delete(Long id) {
        int affectRows = goodstypeDao.deleteByPrimaryKey(id);
        return affectRows;
    }


    @Override
    public Goodstype get(Long id) {
        Goodstype goodstype = goodstypeDao.selectByPrimaryKey(id);
        return goodstype;
    }



}
