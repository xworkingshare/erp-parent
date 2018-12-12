package com.xxx.erp.controller.goodstype;

import com.xxx.erp.bean.goodstype.Goodstype;
import com.xxx.erp.bean.goodstype.GoodstypeQuery;
import com.xxx.erp.common.commonbean.CommonResultListBean;
import com.xxx.erp.common.commonbean.goodstype.GoodstypeParam;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.goodstype.IGoodstypeService;
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
 * @ClassName: GoodstypeController
 * @Description: 商品类型操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  0:38
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/goodstype")
public class GoodstypeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodstypeController.class);

    @Autowired
    IGoodstypeService goodstypeService;


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

        Goodstype goodstype = goodstypeService.get(id);


        return goodstype;
    }

    /**
     *@MethodName： getListByPage
     *@Description： 按条件/ 不按条件，分页列表查询
     *@Params：[goodstypeParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:40
     *@Version： 1.0
     */
    @PostMapping(value = "/getlistByPage", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getListByPage(GoodstypeParam goodstypeParam) throws Exception {

        GoodstypeQuery goodstypeQuery = convertFromParamToBeanQuery(goodstypeParam);

        //按条件，查询列表
        List<Goodstype> goodstypeList = goodstypeService.getList(goodstypeQuery);
        //按条件，查询总条数
        long count = goodstypeService.getCount(goodstypeQuery);

        //封装：结果列表 + 结果总条数
        CommonResultListBean<Goodstype> goodstypeCommonResultListBean = new CommonResultListBean<>(goodstypeList, count);

        return goodstypeCommonResultListBean;
    }


    /**
     *@MethodName： getAllForCombobox
     *@Description：  查询所欲商品类型信息，给下拉框使用
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

        List<Goodstype> list = goodstypeService.getList(new GoodstypeQuery());

        return list;
    }
    

    /**
     *@MethodName： addOne
     *@Description： 新增1个对象
     *@Params：[goodstypeParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:59
     *@Version： 1.0
     */
    @PostMapping(value = "/addOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object addOne(GoodstypeParam goodstypeParam)throws  Exception{

        start();
        if(null!=goodstypeParam){
            int affectRows = goodstypeService.add(goodstypeParam);
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
     *@Params：[goodstypeParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:01
     *@Version： 1.0
     */
    @PostMapping(value = "/updateOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object upateOne(GoodstypeParam goodstypeParam) throws Exception{

        start();
        if(null!=goodstypeParam){
            int affectRows = goodstypeService.update(goodstypeParam);
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
     *@Params：[goodstypeParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:23
     *@Version： 1.0
     */
    @PostMapping(value = "/deleteOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object deleteOne(GoodstypeParam goodstypeParam) throws Exception{

        start();
        if(null!=goodstypeParam){
            int affectRows = goodstypeService.delete(goodstypeParam.getUuid());
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
     *@Params：[goodstypeParam]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.goodstype.GoodstypeQuery
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  15:01
     *@Version： 1.0
     */
    private GoodstypeQuery convertFromParamToBeanQuery(GoodstypeParam goodstypeParam) throws Exception {
        GoodstypeQuery goodstypeQuery = new GoodstypeQuery();

        //封装分页参数
        if(0!=goodstypeParam.getPage() && 0!=goodstypeParam.getRows()){
            goodstypeQuery.setPageSize(goodstypeParam.getRows());
            goodstypeQuery.setPageNo(goodstypeParam.getPage());

        }

        //封装查询参数
        GoodstypeQuery.Criteria goodstypeQueryCriteria = goodstypeQuery.createCriteria();
        if(null!=goodstypeParam){

            if (null!=goodstypeParam.getName()){
                goodstypeQueryCriteria.andNameLike("%"+goodstypeParam.getName()+"%");

            }

        }

        return goodstypeQuery;
    }


}
