package com.xxx.erp.service.impl.dep;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.bean.dep.DepQuery;
import com.xxx.erp.dao.dep.DepDao;
import com.xxx.erp.service.dep.IDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: DepServiceImpl
 * @Description: 部门Service层实现类
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  23:53
 * @Version: 1.0
 **/
@Service
@Transactional
public class DepServiceImpl implements IDepService {

    @Autowired
    DepDao depDao;

    @Override
    public List<Dep> getList(DepQuery depQuery) {
        List<Dep> depList = depDao.selectByExample(depQuery);
        return depList;
    }


    @Override
    public List<Dep> getListByPage(DepQuery depQuery, int pageNo, int pageSize) {
        depQuery.setPageNo(pageNo);
        depQuery.setPageSize(pageSize);
        List<Dep> depList = depDao.selectByExample(depQuery);
        return depList;
    }

    @Override
    public long getCount(DepQuery depQuery) {
        int countResults= depDao.countByExample(depQuery);
        return countResults;
    }

    @Override
    public int add(Dep dep) {
        int affcetRows = depDao.insertSelective(dep);
        return affcetRows;
    }

    @Override
    public int update(Dep dep) {
        int affectRows = depDao.updateByPrimaryKeySelective(dep);
        return affectRows;
    }

    @Override
    public int delete(Long id) {
        int affectRows = depDao.deleteByPrimaryKey(id);
        return affectRows;
    }


    @Override
    public Dep get(Long id) {
        Dep dep = depDao.selectByPrimaryKey(id);
        return dep;
    }
}
