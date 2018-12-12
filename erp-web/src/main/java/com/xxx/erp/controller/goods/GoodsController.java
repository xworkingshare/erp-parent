package com.xxx.erp.controller.goods;

import com.xxx.erp.bean.goods.Goods;
import com.xxx.erp.bean.goods.GoodsQuery;
import com.xxx.erp.bean.goodstype.Goodstype;
import com.xxx.erp.common.commonbean.CommonResultListBean;
import com.xxx.erp.common.commonbean.goods.GoodsParam;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.goods.IGoodsService;
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
 * @ClassName: GoodsController
 * @Description: 商品操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  0:38
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    IGoodsService goodsService;
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

        Goods goods = goodsService.get(id);


        return goods;
    }

    /**
     * @MethodName： getListByPage
     * @Description： 按条件/ 不按条件，分页列表查询
     * @Params：[goodsParam]
     * @ParamComment：
     * @Return：java.lang.Object
     * @Author ：谢万清
     * @CreateTime ：2018/12/8  19:40
     * @Version： 1.0
     */
    @PostMapping(value = "/getlistByPage", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getListByPage(GoodsParam goodsParam) throws Exception {

        GoodsQuery goodsQuery = convertFromParamToBeanQuery(goodsParam);

        //按条件，查询列表
        List<Goods> goodsList = goodsService.getList(goodsQuery);
        for (Goods goods : goodsList) {
            if (null!=goods.getGoodstypeuuid()) {
                Goodstype goodstype = goodstypeService.get(goods.getGoodstypeuuid());
                goods.setGoodstypename(goodstype.getName());
            }
        }


        //按条件，查询总条数
        long count = goodsService.getCount(goodsQuery);

        //封装：结果列表 + 结果总条数
        CommonResultListBean<Goods> goodsCommonResultListBean = new CommonResultListBean<>(goodsList, count);

        return goodsCommonResultListBean;
    }


    /**
     * @MethodName： getAllForCombobox
     * @Description： 查询所欲商品信息，给下拉框使用
     * @Params：[]
     * @ParamComment：
     * @Return：java.lang.Object
     * @Author ：谢万清
     * @CreateTime ：2018/12/9  19:06
     * @Version： 1.0
     */
    @PostMapping(value = "/getAllForCombobox", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getAllForCombobox() throws Exception {

        List<Goods> list = goodsService.getList(new GoodsQuery());

        return list;
    }


    /**
     * @MethodName： addOne
     * @Description： 新增1个对象
     * @Params：[goodsParam]
     * @ParamComment：
     * @Return：java.lang.Object
     * @Author ：谢万清
     * @CreateTime ：2018/12/8  19:59
     * @Version： 1.0
     */
    @PostMapping(value = "/addOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object addOne(GoodsParam goodsParam) throws Exception {

        start();
        if (null != goodsParam) {
            int affectRows = goodsService.add(goodsParam);
            if (affectRows > 0) {
                isSuccess(true);

            } else {
                isSuccess(false);
            }
        } else {
            isSuccess(false);
        }

        return endGetMap();
    }


    /**
     * @MethodName： upateOne
     * @Description： 修改单个对象
     * @Params：[goodsParam]
     * @ParamComment：
     * @Return：java.lang.Object
     * @Author ：谢万清
     * @CreateTime ：2018/12/9  20:01
     * @Version： 1.0
     */
    @PostMapping(value = "/updateOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object upateOne(GoodsParam goodsParam) throws Exception {

        start();
        if (null != goodsParam) {
            int affectRows = goodsService.update(goodsParam);
            if (affectRows > 0) {
                isSuccess(true);

            } else {
                isSuccess(false);
            }
        } else {
            isSuccess(false);
        }

        return endGetMap();
    }


    /***
     *@MethodName： deleteOne
     *@Description： 删除单个对象
     *@Params：[goodsParam]
     *@ParamComment：
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:23
     *@Version： 1.0
     */
    @PostMapping(value = "/deleteOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object deleteOne(GoodsParam goodsParam) throws Exception {

        start();
        if (null != goodsParam) {
            int affectRows = goodsService.delete(goodsParam.getUuid());
            if (affectRows > 0) {
                isSuccess(true);

            } else {
                isSuccess(false);
            }
        } else {
            isSuccess(false);
        }

        return endGetMap();

    }

    /**
     * @MethodName： getDistinctProducerByLike
     * @Description： 根据厂家名，做智能提示查询
     * @Params：[goodsParam]
     * @ParamComment：
     * @Return：java.lang.Object
     * @Author ：谢万清
     * @CreateTime ：2018/12/10  14:39
     * @Version： 1.0
     */
    @PostMapping(value = "/getDistinctProducerByLike", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getDistinctProducerByLike(GoodsParam goodsParam) throws Exception {

        List<Goods> goodsList = null;

        if (null != goodsParam) {
            GoodsQuery goodsQuery = new GoodsQuery();
            goodsQuery.setDistinct(true);
            goodsQuery.setFields("producer");
            GoodsQuery.Criteria criteria = goodsQuery.createCriteria();
            criteria.andProducerLike("%" + goodsParam.getQ() + "%");

            goodsList = goodsService.getList(goodsQuery);

        }


        return goodsList;
    }

    /***
     *@MethodName： convertFromParamToBeanQuery
     *@Description： 将 查询参数，封装到 xxxQuery对象中
     *@Params：[goodsParam]
     *@ParamComment：
     *@Return：com.xxx.erp.bean.goods.GoodsQuery
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  15:01
     *@Version： 1.0
     */
    private GoodsQuery convertFromParamToBeanQuery(GoodsParam goodsParam) throws Exception {
        GoodsQuery goodsQuery = new GoodsQuery();

        //封装分页参数
        if (0 != goodsParam.getPage() && 0 != goodsParam.getRows()) {
            goodsQuery.setPageSize(goodsParam.getRows());
            goodsQuery.setPageNo(goodsParam.getPage());

        }

        //封装查询参数
        GoodsQuery.Criteria goodsQueryCriteria = goodsQuery.createCriteria();
        if (null != goodsParam) {

            if (null != goodsParam.getName()) {
                goodsQueryCriteria.andNameLike("%" + goodsParam.getName() + "%");

            }
            if (null != goodsParam.getOrigin()) {
                goodsQueryCriteria.andOriginLike("%" + goodsParam.getOrigin() + "%");

            }
            if (null != goodsParam.getProducer()) {
                goodsQueryCriteria.andProducerLike("%" + goodsParam.getProducer() + "%");

            }
            if (null != goodsParam.getUnit()) {
                goodsQueryCriteria.andUnitLike("%" + goodsParam.getUnit() + "%");

            }

        }

        return goodsQuery;
    }


}
