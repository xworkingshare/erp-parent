package com.xxx.erp.service.impl.test;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.bean.dep.DepQuery;
import com.xxx.erp.bean.emp.Emp;
import com.xxx.erp.bean.emp.EmpQuery;
import com.xxx.erp.dao.dep.DepDao;
import com.xxx.erp.dao.emp.EmpDao;
import com.xxx.erp.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: TestServiceImpl
 * @Description: 测试类 Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  12:51
 * @Version: 1.0
 **/
@Service
@Transactional
public class TestServiceImpl implements ITestService {

    @Autowired
    DepDao depDao;

    @Autowired
    EmpDao empDao;

    @Override
    public int testTransaction(String tele1, String tele2) throws Exception{

        DepQuery depQuery = new DepQuery();
        EmpQuery empQuery = new EmpQuery();

        Dep dep = new Dep();
        dep.setUuid(1L);
        dep.setTele(tele1);
        Emp emp = new Emp();
        emp.setUuid(1L);
        emp.setTele(tele2);

        int affcetRowsDep = depDao.updateByPrimaryKeySelective(dep);
        int affcetRowsEmp = empDao.updateByPrimaryKeySelective(emp);


        if(1==affcetRowsDep&&1==affcetRowsEmp){
            return 1;
        }


        return 0;
    }
}
