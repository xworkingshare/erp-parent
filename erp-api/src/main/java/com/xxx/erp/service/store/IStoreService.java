package com.xxx.erp.service.store;

import com.xxx.erp.bean.store.Store;
import com.xxx.erp.bean.store.StoreQuery;

import java.util.List;

/**
 * @ClassName: StoreService
 * @Description: 仓库Service层接口
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  2:56
 * @Version: 1.0
 **/
public interface IStoreService {

    /**
     *@MethodName： getList
     *@Description： 根据条件，查询对象列表
     *@Params：[storeQuery]
     *@ParamComment： 
     *@Return：java.util.List<com.xxx.erp.bean.store.Store>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Store> getList(StoreQuery storeQuery) throws  Exception;

    /**
     *@MethodName： getListByPage
     *@Description： 根据条件 ，查询分页对象
     *@Params：[storeQuery, pageNo, pageSize]
     *@ParamComment： 
     *@Return：java.util.List<com.xxx.erp.bean.store.Store>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Store> getListByPage(StoreQuery storeQuery, int pageNo, int pageSize) throws  Exception;

    /**
     *@MethodName： getCount
     *@Description： genuine条件 ，查询count统计值
     *@Params：[storeQuery]
     *@ParamComment： 
     *@Return：long
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public long getCount(StoreQuery storeQuery) throws  Exception;

    /**
     *@MethodName： add
     *@Description： 插入 单个对象
     *@Params：[store]
     *@ParamComment： 
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int add(Store store) throws  Exception;
    
    /**
     *@MethodName： update
     *@Description： 更新 单个对象
     *@Params：[store]
     *@ParamComment： 
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int update(Store store) throws  Exception;
    
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
     *@Return：com.xxx.erp.bean.store.Store
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:52
     *@Version： 1.0
     */
    public Store get(Long id) throws  Exception;
}
