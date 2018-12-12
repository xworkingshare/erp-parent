package com.xxx.erp.service.goods;

import com.xxx.erp.bean.goods.Goods;
import com.xxx.erp.bean.goods.GoodsQuery;

import java.util.List;

/**
* @ClassName:   IGoodsService
* @Description:  商品管理 Service层接口
*                                 
* @Author:           谢万清
* @CreateTime:   2018/12/4  14:57
* @Version:          1.0   
**/
public interface IGoodsService {


    /**
     *@MethodName： getList
     *@Description： 根据条件，查询对象列表
     *@Params：[GoodsQuery]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.goods.Goods>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Goods> getList(GoodsQuery goodsQuery) throws  Exception;

    /**
     *@MethodName： getListByPage
     *@Description： 根据条件 ，查询分页对象
     *@Params：[goodsQuery, pageNo, pageSize]
     *@ParamComment：
     *@Return：java.util.List<com.xxx.erp.bean.goods.Goods>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Goods> getListByPage(GoodsQuery goodsQuery, int pageNo, int pageSize) throws  Exception;

    /**
     *@MethodName： getCount
     *@Description： genuine条件 ，查询count统计值
     *@Params：[goodsQuery]
     *@ParamComment：
     *@Return：long
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public long getCount(GoodsQuery goodsQuery) throws  Exception;

    /**
     *@MethodName： add
     *@Description： 插入 单个对象
     *@Params：[goods]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int add(Goods goods) throws  Exception;

    /**
     *@MethodName： update
     *@Description： 更新 单个对象
     *@Params：[goods]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int update(Goods goods) throws  Exception;

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
     *@Return：com.xxx.erp.bean.goods.Goods
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:52
     *@Version： 1.0
     */
    public Goods get(Long id) throws  Exception;


}