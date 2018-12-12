package com.xxx.erp.service.impl.store;

import com.xxx.erp.bean.store.Store;
import com.xxx.erp.bean.store.StoreQuery;
import com.xxx.erp.dao.store.StoreDao;
import com.xxx.erp.service.store.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: StoreServiceImpl
 * @Description: 仓库Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  23:53
 * @Version: 1.0
 **/
@Service
@Transactional
public class StoreServiceImpl implements IStoreService {

    @Autowired
    StoreDao storeDao;

    @Override
    public List<Store> getList(StoreQuery storeQuery) {
        List<Store> storeList = storeDao.selectByExample(storeQuery);
        return storeList;
    }


    @Override
    public List<Store> getListByPage(StoreQuery storeQuery, int pageNo, int pageSize) {
        storeQuery.setPageNo(pageNo);
        storeQuery.setPageSize(pageSize);
        List<Store> storeList = storeDao.selectByExample(storeQuery);
        return storeList;
    }

    @Override
    public long getCount(StoreQuery storeQuery) {
        int countResults= storeDao.countByExample(storeQuery);
        return countResults;
    }

    @Override
    public int add(Store store) {
        int affcetRows = storeDao.insertSelective(store);
        return affcetRows;
    }

    @Override
    public int update(Store store) {
        int affectRows = storeDao.updateByPrimaryKeySelective(store);
        return affectRows;
    }

    @Override
    public int delete(Long id) {
        int affectRows = storeDao.deleteByPrimaryKey(id);
        return affectRows;
    }


    @Override
    public Store get(Long id) {
        Store store = storeDao.selectByPrimaryKey(id);
        return store;
    }
}
