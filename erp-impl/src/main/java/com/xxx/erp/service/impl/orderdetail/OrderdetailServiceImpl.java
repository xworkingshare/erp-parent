package com.xxx.erp.service.impl.orderdetail;

import com.xxx.erp.bean.orderdetail.Orderdetail;
import com.xxx.erp.bean.orderdetail.OrderdetailQuery;
import com.xxx.erp.dao.orderdetail.OrderdetailDao;
import com.xxx.erp.service.orderdetail.IOrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: OrderdetailServiceImpl
 * @Description: 订单明细=订单项Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  23:53
 * @Version: 1.0
 **/
@Service
@Transactional
public class OrderdetailServiceImpl implements IOrderdetailService {

    @Autowired
    OrderdetailDao orderdetailDao;

    @Override
    public List<Orderdetail> getList(OrderdetailQuery orderdetailQuery) {
        List<Orderdetail> orderdetailList = orderdetailDao.selectByExample(orderdetailQuery);
        return orderdetailList;
    }


    @Override
    public List<Orderdetail> getListByPage(OrderdetailQuery orderdetailQuery, int pageNo, int pageSize) {
        orderdetailQuery.setPageNo(pageNo);
        orderdetailQuery.setPageSize(pageSize);
        List<Orderdetail> orderdetailList = orderdetailDao.selectByExample(orderdetailQuery);
        return orderdetailList;
    }

    @Override
    public long getCount(OrderdetailQuery orderdetailQuery) {
        int countResults= orderdetailDao.countByExample(orderdetailQuery);
        return countResults;
    }

    @Override
    public int add(Orderdetail orderdetail) {
        int affcetRows = orderdetailDao.insertSelective(orderdetail);
        return affcetRows;
    }

    @Override
    public int update(Orderdetail orderdetail) {
        int affectRows = orderdetailDao.updateByPrimaryKeySelective(orderdetail);
        return affectRows;
    }

    @Override
    public int delete(Long id) {
        int affectRows = orderdetailDao.deleteByPrimaryKey(id);
        return affectRows;
    }


    @Override
    public Orderdetail get(Long id) {
        Orderdetail orderdetail = orderdetailDao.selectByPrimaryKey(id);
        return orderdetail;
    }

    @Override
    public int addBatch(List<Orderdetail> orderdetails) {
        int affcetRows = orderdetailDao.insertBatch(orderdetails);
        return affcetRows;
    }
}
