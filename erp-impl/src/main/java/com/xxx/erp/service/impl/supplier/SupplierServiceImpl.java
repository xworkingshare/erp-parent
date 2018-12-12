package com.xxx.erp.service.impl.supplier;

import com.xxx.erp.bean.supplier.Supplier;
import com.xxx.erp.bean.supplier.SupplierQuery;
import com.xxx.erp.dao.supplier.SupplierDao;
import com.xxx.erp.service.supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: SupplierServiceImpl
 * @Description: 客户/供应商管理 Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  15:00
 * @Version: 1.0
 **/
@Service
@Transactional
public class SupplierServiceImpl implements ISupplierService {


    @Autowired
    SupplierDao supplierDao;

    @Override
    public List<Supplier> getList(SupplierQuery supplierQuery) {
        List<Supplier> supplierList = supplierDao.selectByExample(supplierQuery);
        return supplierList;
    }


    @Override
    public List<Supplier> getListByPage(SupplierQuery supplierQuery, int pageNo, int pageSize) {
        supplierQuery.setPageNo(pageNo);
        supplierQuery.setPageSize(pageSize);
        List<Supplier> supplierList = supplierDao.selectByExample(supplierQuery);
        return supplierList;
    }

    @Override
    public long getCount(SupplierQuery supplierQuery) {
        int countResults= supplierDao.countByExample(supplierQuery);
        return countResults;
    }

    @Override
    public int add(Supplier supplier) {
        int affcetRows = supplierDao.insertSelective(supplier);
        return affcetRows;
    }

    @Override
    public int update(Supplier supplier) {
        int affectRows = supplierDao.updateByPrimaryKeySelective(supplier);
        return affectRows;
    }

    @Override
    public int delete(Long id) {
        int affectRows = supplierDao.deleteByPrimaryKey(id);
        return affectRows;
    }


    @Override
    public Supplier get(Long id) {
        Supplier supplier = supplierDao.selectByPrimaryKey(id);
        return supplier;
    }



}
