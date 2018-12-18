package com.xxx.erp.service.impl.orders;

import com.xxx.erp.bean.orderdetail.Orderdetail;
import com.xxx.erp.bean.orders.Orders;
import com.xxx.erp.bean.orders.OrdersQuery;
import com.xxx.erp.dao.orderdetail.OrderdetailDao;
import com.xxx.erp.dao.orders.OrdersDao;
import com.xxx.erp.service.orders.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: OrdersServiceImpl
 * @Description: 订单Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  23:53
 * @Version: 1.0
 **/
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService{

    @Autowired
    OrdersDao ordersDao;
    @Autowired
    OrderdetailDao orderdetailDao;

    @Override
    public List<Orders> getList(OrdersQuery ordersQuery) {
        List<Orders> ordersList = ordersDao.selectByExample(ordersQuery);
        return ordersList;
    }


    @Override
    public List<Orders> getListByPage(OrdersQuery ordersQuery, int pageNo, int pageSize) {
        ordersQuery.setPageNo(pageNo);
        ordersQuery.setPageSize(pageSize);
        List<Orders> ordersList = ordersDao.selectByExample(ordersQuery);
        return ordersList;
    }

    @Override
    public long getCount(OrdersQuery ordersQuery) {
        int countResults= ordersDao.countByExample(ordersQuery);
        return countResults;
    }

    @Override
    public int add(Orders orders) {
        int affcetRows = ordersDao.insertSelective(orders);
        return affcetRows;
    }

    @Override
    public int update(Orders orders) {
        int affectRows = ordersDao.updateByPrimaryKeySelective(orders);
        return affectRows;
    }

    @Override
    public int delete(Long id) {
        int affectRows = ordersDao.deleteByPrimaryKey(id);
        return affectRows;
    }


    @Override
    public Orders get(Long id) {
        Orders orders = ordersDao.selectByPrimaryKey(id);
        return orders;
    }

    @Override
    public String getMaxOrderNum(String currentDate) {
        String maxOrderNum = ordersDao.selectMaxOrderNum(currentDate);
        return maxOrderNum;
    }

    @Override
    public boolean insertOrdersAndOrderdetail(Orders orders, List<Orderdetail> orderdetails) throws Exception {

        //插入订单(注意：这里的插入的orders对象，使用了自增主键返回)
        int affectRowsOrders = ordersDao.insertSelective(orders);
        for (Orderdetail orderdetail : orderdetails) {
            orderdetail.setOrderuuid(orders.getUuid());
            orderdetail.setState(orders.getState());
        }


        //插入订单明细=订单项
        int affcetRowsOrderdetails = orderdetailDao.insertBatch(orderdetails);

        boolean  flag = false;
        if(affectRowsOrders > 0&&affcetRowsOrderdetails == orderdetails.size()){
            flag = true;
        }
        return flag;
    }
}
