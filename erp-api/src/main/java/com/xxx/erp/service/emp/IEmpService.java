package com.xxx.erp.service.emp;

import com.xxx.erp.bean.emp.Emp;
import com.xxx.erp.bean.emp.EmpQuery;

import java.util.List;

/**
* @ClassName:   IEmpService
* @Description:  员工管理 Service层接口
*                                 
* @Author:           谢万清
* @CreateTime:   2018/12/4  14:57
* @Version:          1.0   
**/
public interface IEmpService {


    /**
     *@MethodName： getList
     *@Description： 根据条件，查询对象列表
     *@Params：[empQuery]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.emp.Emp>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Emp> getList(EmpQuery empQuery) throws  Exception;

    /**
     *@MethodName： getListByPage
     *@Description： 根据条件 ，查询分页对象
     *@Params：[empQuery, pageNo, pageSize]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.emp.Emp>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Emp> getListByPage(EmpQuery empQuery, int pageNo, int pageSize) throws  Exception;

    /**
     *@MethodName： getCount
     *@Description： genuine条件 ，查询count统计值
     *@Params：[empQuery]
     *@ParamComment：
     *@Return：long
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public long getCount(EmpQuery empQuery) throws  Exception;

    /**
     *@MethodName： add
     *@Description： 插入 单个对象
     *@Params：[emp]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int add(Emp emp) throws  Exception;

    /**
     *@MethodName： update
     *@Description： 更新 单个对象
     *@Params：[emp]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int update(Emp emp) throws  Exception;

    /**
     *@MethodName： delete
     *@Description： 根据  id ，删除单个对象
     *@Params：[id]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int delete(Long id) throws  Exception;

    /**
     *@MethodName： get
     *@Description： 根据 id ，查询单个对象
     *@Params：[id]
     *@ParamComment：
     *@Return：com.xxx.erp.bean.emp.Emp
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:52
     *@Version： 1.0
     */
    public Emp get(Long id) throws  Exception;


}