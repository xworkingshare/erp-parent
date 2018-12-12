package com.xxx.erp.controller.supplier;

import com.xxx.erp.bean.supplier.Supplier;
import com.xxx.erp.bean.supplier.SupplierQuery;
import com.xxx.erp.common.commonbean.CommonResultListBean;
import com.xxx.erp.common.commonbean.supplier.SupplierParam;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.supplier.ISupplierService;
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
 * @ClassName: SupplierController
 * @Description: 客户/供货商操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  0:38
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/supplier")
public class SupplierController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    ISupplierService supplierService;


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

        Supplier supplier = supplierService.get(id);


        return supplier;
    }

    /**
     *@MethodName： getListByPage
     *@Description： 按条件/ 不按条件，分页列表查询
     *@Params：[supplierParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:40
     *@Version： 1.0
     */
    @PostMapping(value = "/getlistByPage", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getListByPage(SupplierParam supplierParam) throws Exception {

        SupplierQuery supplierQuery = convertFromParamToBeanQuery(supplierParam);

        //按条件，查询列表
        List<Supplier> supplierList = supplierService.getList(supplierQuery);
        //按条件，查询总条数
        long count = supplierService.getCount(supplierQuery);

        //封装：结果列表 + 结果总条数
        CommonResultListBean<Supplier> supplierCommonResultListBean = new CommonResultListBean<>(supplierList, count);

        return supplierCommonResultListBean;
    }


    /**
     *@MethodName： getAllForCombobox
     *@Description：  查询所有客户/供货商信息，给下拉框使用
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

        List<Supplier> list = supplierService.getList(new SupplierQuery());

        return list;
    }
    

    /**
     *@MethodName： addOne
     *@Description： 新增1个对象
     *@Params：[supplierParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:59
     *@Version： 1.0
     */
    @PostMapping(value = "/addOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object addOne(SupplierParam supplierParam)throws  Exception{

        start();
        if(null!=supplierParam){
            int affectRows = supplierService.add(supplierParam);
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
     *@Params：[supplierParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:01
     *@Version： 1.0
     */
    @PostMapping(value = "/updateOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object upateOne(SupplierParam supplierParam) throws Exception{

        start();
        if(null!=supplierParam){
            int affectRows = supplierService.update(supplierParam);
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
     *@Params：[supplierParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:23
     *@Version： 1.0
     */
    @PostMapping(value = "/deleteOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object deleteOne(SupplierParam supplierParam) throws Exception{

        start();
        if(null!=supplierParam){
            int affectRows = supplierService.delete(supplierParam.getUuid());
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
     *@Params：[supplierParam]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.supplier.SupplierQuery
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  15:01
     *@Version： 1.0
     */
    private SupplierQuery convertFromParamToBeanQuery(SupplierParam supplierParam) throws Exception {
        SupplierQuery supplierQuery = new SupplierQuery();

        //封装分页参数
        if(0!=supplierParam.getPage() && 0!=supplierParam.getRows()){
            supplierQuery.setPageSize(supplierParam.getRows());
            supplierQuery.setPageNo(supplierParam.getPage());

        }

        //封装查询参数
        SupplierQuery.Criteria supplierQueryCriteria = supplierQuery.createCriteria();
        if(null!=supplierParam){

            if (null!=supplierParam.getName()){
                supplierQueryCriteria.andNameLike("%"+supplierParam.getName()+"%");

            }
            if(null!=supplierParam.getAddress()){
                supplierQueryCriteria.andAddressLike("%"+supplierParam.getAddress()+"%");

            }
            if(null!=supplierParam.getContact()){
                supplierQueryCriteria.andContactLike("%"+supplierParam.getContact()+"%");

            }
            if(null!=supplierParam.getTele()){
                supplierQueryCriteria.andTeleLike("%"+supplierParam.getTele()+"%");

            }
            if(null!=supplierParam.getType()){
                supplierQueryCriteria.andTypeEqualTo(supplierParam.getType());

            }
        }

        return supplierQuery;
    }


}
