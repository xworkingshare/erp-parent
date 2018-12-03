package com.xxx.erp.service.dep;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.bean.dep.DepQuery;

import java.util.List;

/**
 * @ClassName: DepService
 * @Description: 部门Service层接口
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  2:56
 * @Version: 1.0
 **/
public interface IDepService {

    /**
     *@MethodName： getList
     *@Description： 根据条件，查询对象列表
     *@Params：[depQuery]
     *@ParamComment： 
     *@Return：java.util.List<com.xxx.erp.bean.dep.Dep>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Dep> getList(DepQuery depQuery) throws  Exception;

    /**
     *@MethodName： getListByPage
     *@Description： 根据条件 ，查询分页对象
     *@Params：[depQuery, pageNo, pageSize]
     *@ParamComment： 
     *@Return：java.util.List<com.xxx.erp.bean.dep.Dep>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Dep> getListByPage(DepQuery depQuery, int pageNo, int pageSize) throws  Exception;

    /**
     *@MethodName： getCount
     *@Description： genuine条件 ，查询count统计值
     *@Params：[depQuery]
     *@ParamComment： 
     *@Return：long
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public long getCount(DepQuery depQuery) throws  Exception;

    /**
     *@MethodName： add
     *@Description： 插入 单个对象
     *@Params：[dep]
     *@ParamComment： 
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int add(Dep dep) throws  Exception;
    
    /**
     *@MethodName： update
     *@Description： 更新 单个对象
     *@Params：[dep]
     *@ParamComment： 
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int update(Dep dep) throws  Exception;
    
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
     *@Return：com.xxx.erp.bean.dep.Dep
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:52
     *@Version： 1.0
     */
    public Dep get(Long id) throws  Exception;
}
