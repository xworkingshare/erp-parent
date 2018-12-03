package com.xxx.erp.service.impl.test;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.dao.dep.DepDao;
import com.xxx.erp.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: TestServiceImpl
 * @Description: 测试Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  10:53
 * @Version: 1.0
 **/
@Service
@Transactional
public class TestServiceImpl implements ITestService {

    @Autowired
    private DepDao depDao;


    @Override
    public List<Dep> getDepList() {

        List<Dep> depList = depDao.selectByExample(null);

        return depList;
    }
}
