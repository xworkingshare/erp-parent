package com.xxx.erp.service.impl.goods;

import com.xxx.erp.bean.goods.Goods;
import com.xxx.erp.bean.goods.GoodsQuery;
import com.xxx.erp.dao.goods.GoodsDao;
import com.xxx.erp.dao.goodstype.GoodstypeDao;
import com.xxx.erp.service.goods.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: GoodsServiceImpl
 * @Description: 商品管理 Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  15:00
 * @Version: 1.0
 **/
@Service
@Transactional
public class GoodsServiceImpl implements IGoodsService {


    @Autowired
    GoodsDao goodsDao;

    GoodstypeDao goodstypeDao;

    @Override
    public List<Goods> getList(GoodsQuery goodsQuery) {
        List<Goods> goodsList = goodsDao.selectByExample(goodsQuery);
        return goodsList;
    }


    @Override
    public List<Goods> getListByPage(GoodsQuery goodsQuery, int pageNo, int pageSize) {
        goodsQuery.setPageNo(pageNo);
        goodsQuery.setPageSize(pageSize);
        List<Goods> goodsList = goodsDao.selectByExample(goodsQuery);
        return goodsList;
    }

    @Override
    public long getCount(GoodsQuery goodsQuery) {
        int countResults= goodsDao.countByExample(goodsQuery);
        return countResults;
    }

    @Override
    public int add(Goods goods) {
        int affcetRows = goodsDao.insertSelective(goods);
        return affcetRows;
    }

    @Override
    public int update(Goods goods) {
        int affectRows = goodsDao.updateByPrimaryKeySelective(goods);
        return affectRows;
    }

    @Override
    public int delete(Long id) {
        int affectRows = goodsDao.deleteByPrimaryKey(id);
        return affectRows;
    }


    @Override
    public Goods get(Long id) {
        Goods goods = goodsDao.selectByPrimaryKey(id);
        return goods;
    }



}
