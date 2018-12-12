package com.xxx.erp.controller.dep;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.bean.dep.DepQuery;
import com.xxx.erp.common.commonbean.CommonResultListBean;
import com.xxx.erp.common.commonbean.dep.DepParam;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.dep.IDepService;
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
 * @ClassName: DepController
 * @Description: 部门操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  0:38
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/dep")
public class DepController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DepController.class);

    @Autowired
    IDepService depService;


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

        Dep dep = depService.get(id);


        return dep;
    }

    /**
     *@MethodName： getListByPage
     *@Description： 按条件/ 不按条件，分页列表查询
     *@Params：[depParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:40
     *@Version： 1.0
     */
    @PostMapping(value = "/getlistByPage", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getListByPage(DepParam depParam) throws Exception {

        DepQuery depQuery = convertFromParamToBeanQuery(depParam);

        //按条件，查询列表
        List<Dep> depList = depService.getList(depQuery);
        //按条件，查询总条数
        long count = depService.getCount(depQuery);

        //封装：结果列表 + 结果总条数
        CommonResultListBean<Dep> depCommonResultListBean = new CommonResultListBean<>(depList, count);

        return depCommonResultListBean;
    }


    /**
     *@MethodName： getAllForCombobox
     *@Description：  查询所欲部门信息，给下拉框使用
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

        List<Dep> list = depService.getList(new DepQuery());

        return list;
    }
    

    /**
     *@MethodName： addOne
     *@Description： 新增1个对象
     *@Params：[depParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  19:59
     *@Version： 1.0
     */
    @PostMapping(value = "/addOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object addOne(DepParam depParam)throws  Exception{

        start();
        if(null!=depParam){
            int affectRows = depService.add(depParam);
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
     *@Params：[depParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:01
     *@Version： 1.0
     */
    @PostMapping(value = "/updateOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object upateOne(DepParam depParam) throws Exception{

        start();
        if(null!=depParam){
            int affectRows = depService.update(depParam);
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
     *@Params：[depParam]
     *@ParamComment： 
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:23
     *@Version： 1.0
     */
    @PostMapping(value = "/deleteOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object deleteOne(DepParam depParam) throws Exception{

        start();
        if(null!=depParam){
            int affectRows = depService.delete(depParam.getUuid());
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
     *@Params：[depParam]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.dep.DepQuery
     *@Author ：谢万清
     *@CreateTime ：2018/12/8  15:01
     *@Version： 1.0
     */
    private DepQuery convertFromParamToBeanQuery(DepParam depParam) throws Exception {
        DepQuery depQuery = new DepQuery();

        //封装分页参数
        if(0!=depParam.getPage() && 0!=depParam.getRows()){
            depQuery.setPageSize(depParam.getRows());
            depQuery.setPageNo(depParam.getPage());

        }

        //封装查询参数
        DepQuery.Criteria depQueryCriteria = depQuery.createCriteria();
        if(null!=depParam){

            if (null!=depParam.getName()){
                depQueryCriteria.andNameLike("%"+depParam.getName()+"%");

            }
            if(null!=depParam.getTele()){
                depQueryCriteria.andTeleLike("%"+depParam.getTele()+"%");

            }

        }

        return depQuery;
    }


}
