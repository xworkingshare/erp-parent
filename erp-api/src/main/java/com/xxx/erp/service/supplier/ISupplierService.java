package com.xxx.erp.service.supplier;

import com.xxx.erp.bean.supplier.Supplier;
import com.xxx.erp.bean.supplier.SupplierQuery;

import java.util.List;

/**
* @ClassName:   ISupplierService
* @Description:  客户/供应商管理 Service层接口
*                                 
* @Author:           谢万清
* @CreateTime:   2018/12/4  14:57
* @Version:          1.0   
**/
public interface ISupplierService {


    /**
     *@MethodName： getList
     *@Description： 根据条件，查询对象列表
     *@Params：[SupplierQuery]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.supplier.Supplier>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Supplier> getList(SupplierQuery supplierQuery) throws  Exception;

    /**
     *@MethodName： getListByPage
     *@Description： 根据条件 ，查询分页对象
     *@Params：[supplierQuery, pageNo, pageSize]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.supplier.Supplier>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Supplier> getListByPage(SupplierQuery supplierQuery, int pageNo, int pageSize) throws  Exception;

    /**
     *@MethodName： getCount
     *@Description： genuine条件 ，查询count统计值
     *@Params：[supplierQuery]
     *@ParamComment：
     *@Return：long
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public long getCount(SupplierQuery supplierQuery) throws  Exception;

    /**
     *@MethodName： add
     *@Description： 插入 单个对象
     *@Params：[supplier]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int add(Supplier supplier) throws  Exception;

    /**
     *@MethodName： update
     *@Description： 更新 单个对象
     *@Params：[supplier]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int update(Supplier supplier) throws  Exception;

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
     *@Return：com.xxx.erp.bean.supplier.Supplier
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:52
     *@Version： 1.0
     */
    public Supplier get(Long id) throws  Exception;


}