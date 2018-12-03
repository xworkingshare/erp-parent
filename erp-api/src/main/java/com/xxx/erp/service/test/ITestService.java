package com.xxx.erp.service.test;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.bean.emp.Emp;

import java.util.List;

/**
 * @ClassName: ITestService
 * @Description: 测试Service层接口
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  10:52
 * @Version: 1.0
 **/


public interface ITestService {

    /**
     *@MethodName： getDepList
     *@Description： 查询所有部门
     *@Params：[]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.dep.Dep>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  10:56
     *@Version： 1.0
     */
    public List<Dep>  getDepList();
    
    
    /**
     *@MethodName： getEmpList
     *@Description： 查询所有员工
     *@Params：[]
     *@ParamComment： 
     *@Return：java.util.List<com.xxx.erp.bean.emp.Emp>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  19:59
     *@Version： 1.0
     */
    public  List<Emp> getEmpList();

}
