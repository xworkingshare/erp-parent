package com.xxx.erp.service.goodstype;

import com.xxx.erp.bean.goodstype.Goodstype;
import com.xxx.erp.bean.goodstype.GoodstypeQuery;

import java.util.List;

/**
* @ClassName:   IGoodstypeService
* @Description:  商品类型管理 Service层接口
*                                 
* @Author:           谢万清
* @CreateTime:   2018/12/4  14:57
* @Version:          1.0   
**/
public interface IGoodstypeService {


    /**
     *@MethodName： getList
     *@Description： 根据条件，查询对象列表
     *@Params：[GoodstypeQuery]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.goodstype.Goodstype>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Goodstype> getList(GoodstypeQuery goodstypeQuery) throws  Exception;

    /**
     *@MethodName： getListByPage
     *@Description： 根据条件 ，查询分页对象
     *@Params：[goodstypeQuery, pageNo, pageSize]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.goodstype.Goodstype>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Goodstype> getListByPage(GoodstypeQuery goodstypeQuery, int pageNo, int pageSize) throws  Exception;

    /**
     *@MethodName： getCount
     *@Description： genuine条件 ，查询count统计值
     *@Params：[goodstypeQuery]
     *@ParamComment：
     *@Return：long
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public long getCount(GoodstypeQuery goodstypeQuery) throws  Exception;

    /**
     *@MethodName： add
     *@Description： 插入 单个对象
     *@Params：[goodstype]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int add(Goodstype goodstype) throws  Exception;

    /**
     *@MethodName： update
     *@Description： 更新 单个对象
     *@Params：[goodstype]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int update(Goodstype goodstype) throws  Exception;

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
     *@Return：com.xxx.erp.bean.goodstype.Goodstype
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:52
     *@Version： 1.0
     */
    public Goodstype get(Long id) throws  Exception;


}