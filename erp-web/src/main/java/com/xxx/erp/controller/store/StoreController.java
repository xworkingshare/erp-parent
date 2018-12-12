package com.xxx.erp.controller.store;

import com.xxx.erp.bean.store.Store;
import com.xxx.erp.bean.store.StoreQuery;
import com.xxx.erp.common.commonbean.CommonResultListBean;
import com.xxx.erp.common.commonbean.store.StoreParam;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.store.IStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: StoreController
 * @Description: 仓库操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  0:38
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/store")
public class StoreController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    IStoreService storeService;


    /**
     * @MethodName： getOneById
     * @Description： 根据id，查询单个对象，用于修改框展示
     * @Params：[id]
     * @ParamComment：
     * @Return：java.util.Map<java.lang.String,java.lang.Object>
     * @Author ：谢万清
     * @CreateTime ：2018/12/8  0:48
     * @Version： 1.0
     */
    @GetMapping("/getOneById")
    @ResponseBody
    public Object getOneById(Long id) throws Exception {

        Store store = storeService.get(id);


        return store;
    }

    /**
     *@MethodName： getListByPage
     *@Description： 按条件/ 不按条件，分页列表查询
     *@Params：[storeParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:40
     *@Version： 1.0
     */
    @PostMapping(value = "/getlistByPage", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getListByPage(StoreParam storeParam) throws Exception {

        StoreQuery storeQuery = convertFromParamToBeanQuery(storeParam);

        //按条件，查询列表
        List<Store> storeList = storeService.getList(storeQuery);
        //按条件，查询总条数
        long count = storeService.getCount(storeQuery);

        //封装：结果列表 + 结果总条数
        CommonResultListBean<Store> storeCommonResultListBean = new CommonResultListBean<>(storeList, count);

        return storeCommonResultListBean;
    }


    /**
     *@MethodName： getAllForCombobox
     *@Description：  查询所欲仓库信息，给下拉框使用
     *@Params：[]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  19:06
     *@Version： 1.0
     */
    @PostMapping(value = "/getAllForCombobox", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object  getAllForCombobox() throws  Exception{

        List<Store> list = storeService.getList(new StoreQuery());

        return list;
    }
    

    /**
     *@MethodName： addOne
     *@Description： 新增1个对象
     *@Params：[storeParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:59
     *@Version： 1.0
     */
    @PostMapping(value = "/addOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object addOne(StoreParam storeParam)throws  Exception{

        start();
        if(null!=storeParam){
            int affectRows = storeService.add(storeParam);
            if(affectRows > 0){
                isSuccess(true);

            }else {
                isSuccess(false);
            }
        }else {
            isSuccess(false);
        }

        return endGetMap();
    }


    /**
     *@MethodName： upateOne
     *@Description： 修改单个对象
     *@Params：[storeParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:01
     *@Version： 1.0
     */
    @PostMapping(value = "/updateOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object upateOne(StoreParam storeParam) throws Exception{

        start();
        if(null!=storeParam){
            int affectRows = storeService.update(storeParam);
            if(affectRows > 0){
                isSuccess(true);

            }else {
                isSuccess(false);
            }
        }else {
            isSuccess(false);
        }

        return endGetMap();
    }


    /***
     *@MethodName： deleteOne
     *@Description： 删除单个对象
     *@Params：[storeParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:23
     *@Version： 1.0
     */
    @PostMapping(value = "/deleteOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object deleteOne(StoreParam storeParam) throws Exception{

        start();
        if(null!=storeParam){
            int affectRows = storeService.delete(storeParam.getUuid());
            if(affectRows > 0){
                isSuccess(true);

            }else {
                isSuccess(false);
            }
        }else {
            isSuccess(false);
        }

        return endGetMap();

    }


    /***
     *@MethodName： convertFromParamToBeanQuery
     *@Description：   将 查询参数，封装到 xxxQuery对象中
     *@Params：[storeParam]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.store.StoreQuery
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  15:01
     *@Version： 1.0
     */
    private StoreQuery convertFromParamToBeanQuery(StoreParam storeParam) throws Exception {
        StoreQuery storeQuery = new StoreQuery();

        //封装分页参数
        if(0!=storeParam.getPage() && 0!=storeParam.getRows()){
            storeQuery.setPageSize(storeParam.getRows());
            storeQuery.setPageNo(storeParam.getPage());

        }

        //封装查询参数
        StoreQuery.Criteria storeQueryCriteria = storeQuery.createCriteria();
        if(null!=storeParam){

            if (null!=storeParam.getName()){
                storeQueryCriteria.andNameLike("%"+storeParam.getName()+"%");

            }
            if(null!=storeParam.getAddress()){
                storeQueryCriteria.andAddressLike("%"+storeParam.getAddress()+"%");

            }

        }

        return storeQuery;
    }


}
