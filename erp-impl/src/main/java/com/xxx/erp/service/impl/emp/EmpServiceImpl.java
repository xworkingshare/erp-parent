package com.xxx.erp.service.impl.emp;

import com.xxx.erp.bean.emp.Emp;
import com.xxx.erp.bean.emp.EmpQuery;
import com.xxx.erp.dao.emp.EmpDao;
import com.xxx.erp.service.emp.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: EmpServiceImpl
 * @Description: 员工管理 Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  15:00
 * @Version: 1.0
 **/
@Service
@Transactional
public class EmpServiceImpl implements IEmpService {


    @Autowired
    EmpDao empDao;

    @Override
    public List<Emp> getList(EmpQuery empQuery) {
        List<Emp> empList = empDao.selectByExample(empQuery);
        return empList;
    }


    @Override
    public List<Emp> getListByPage(EmpQuery empQuery, int pageNo, int pageSize) {
        empQuery.setPageNo(pageNo);
        empQuery.setPageSize(pageSize);
        List<Emp> empList = empDao.selectByExample(empQuery);
        return empList;
    }

    @Override
    public long getCount(EmpQuery empQuery) {
        int countResults= empDao.countByExample(empQuery);
        return countResults;
    }

    @Override
    public int add(Emp emp) {
        int affcetRows = empDao.insertSelective(emp);
        return affcetRows;
    }

    @Override
    public int update(Emp emp) {
        int affectRows = empDao.updateByPrimaryKeySelective(emp);
        return affectRows;
    }

    @Override
    public int delete(Long id) {
        int affectRows = empDao.deleteByPrimaryKey(id);
        return affectRows;
    }


    @Override
    public Emp get(Long id) {
        Emp emp = empDao.selectByPrimaryKey(id);
        return emp;
    }



}
