package com.xxx.erp.service.orderdetail;

import com.xxx.erp.bean.orderdetail.Orderdetail;
import com.xxx.erp.bean.orderdetail.OrderdetailQuery;

import java.util.List;

/**
 * @ClassName: OrderdetailService
 * @Description: 订单明细=订单项Service层接口
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  2:56
 * @Version: 1.0
 **/
public interface IOrderdetailService {

    /**
     *@MethodName： getList
     *@Description： 根据条件，查询对象列表
     *@Params：[orderdetailQuery]
     *@ParamComment： 
     *@Return：java.util.List<com.xxx.erp.bean.orderdetail.Orderdetail>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Orderdetail> getList(OrderdetailQuery orderdetailQuery) throws  Exception;

    /**
     *@MethodName： getListByPage
     *@Description： 根据条件 ，查询分页对象
     *@Params：[orderdetailQuery, pageNo, pageSize]
     *@ParamComment： 
     *@Return：java.util.List<com.xxx.erp.bean.orderdetail.Orderdetail>
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:50
     *@Version： 1.0
     */
    public List<Orderdetail> getListByPage(OrderdetailQuery orderdetailQuery, int pageNo, int pageSize) throws  Exception;

    /**
     *@MethodName： getCount
     *@Description： genuine条件 ，查询count统计值
     *@Params：[orderdetailQuery]
     *@ParamComment： 
     *@Return：long
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public long getCount(OrderdetailQuery orderdetailQuery) throws  Exception;

    /**
     *@MethodName： add
     *@Description： 插入 单个对象
     *@Params：[orderdetail]
     *@ParamComment： 
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int add(Orderdetail orderdetail) throws  Exception;
    
    /**
     *@MethodName： update
     *@Description： 更新 单个对象
     *@Params：[orderdetail]
     *@ParamComment： 
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:51
     *@Version： 1.0
     */
    public int update(Orderdetail orderdetail) throws  Exception;
    
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
     *@Return：com.xxx.erp.bean.orderdetail.Orderdetail
     *@Author ：谢万清
     *@CreateTime ：2018/12/3  23:52
     *@Version： 1.0
     */
    public Orderdetail get(Long id) throws  Exception;


    /**
     *@MethodName： addBatch
     *@Description：  批量插入 orderdetail
     *@Params：[orderdetails]
     *@ParamComment：
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/12  20:34
     *@Version： 1.0
     */
    int addBatch(List<Orderdetail> orderdetails);
}
