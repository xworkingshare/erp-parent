package com.xxx.erp.controller.emp;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.bean.emp.Emp;
import com.xxx.erp.bean.emp.EmpQuery;
import com.xxx.erp.bean.emp.EmpResult;
import com.xxx.erp.common.commonbean.CommonResultListBean;
import com.xxx.erp.common.commonbean.emp.EmpParam;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.dep.IDepService;
import com.xxx.erp.service.emp.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: EmpController
 * @Description: Emp控制层操作类
 * @Author: 谢万清
 * @CreateTime: 2018/12/9  14:26
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/emp")
public class EmpController extends BaseController {



    @Autowired
    IEmpService empService;

    @Autowired
    IDepService depService;

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
    public Object getListByPage(EmpParam empParam) throws Exception {

        EmpQuery empQuery = convertFromParamToBeanQuery(empParam);

        List<Emp> empList = empService.getList(empQuery);
        for (Emp emp : empList) {
            Long depuuid = emp.getDepuuid();
            Dep dep = depService.get(depuuid);
            emp.setDepName(dep.getName());
        }

        long count = empService.getCount(empQuery);
        CommonResultListBean<Emp> empCommonResultListBean = new CommonResultListBean<>(empList, count);

        return empCommonResultListBean;
    }



    /***
     *@MethodName： deleteOne
     *@Description： 删除单个对象
     *@Params：[depParam]
     *@ParamComment：
     *@Return：java.lang.Object
     *@Author ：谢万清
     *@CreateTime ：2018/12/9  20:16
     *@Version： 1.0
     */
    @PostMapping(value = "/deleteOne", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object deleteOne(EmpParam empParam) throws Exception{

        start();
        if(null!=empParam){
            int affectRows = empService.delete(empParam.getUuid());
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
    public Object addOne(EmpParam empParam)throws  Exception{

        start();
        if(null!=empParam){

            //日期从字符串，转换为Date对象
            String birthdayString = empParam.getBirthdayString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(birthdayString);
            empParam.setBirthday(date);

            int affectRows = empService.add(empParam);
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

        Emp emp = empService.get(id);

        EmpResult empResult = new EmpResult(emp);
        return empResult;
    }

    /**
     *@MethodName： getAllForCombobox
     *@Description：  查询所欲员工信息，给下拉框使用
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

        List<Emp> list = empService.getList(new EmpQuery());

        return list;
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
    public Object upateOne(EmpParam empParam) throws Exception{

        start();
        if(null!=empParam){

            //日期从字符串，转换为Date对象
            String birthdayString = empParam.getBirthdayString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(birthdayString);
            empParam.setBirthday(date);

            int affectRows = empService.update(empParam);
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




    private EmpQuery convertFromParamToBeanQuery(EmpParam empParam) throws ParseException {
        EmpQuery empQuery = new EmpQuery();
        empQuery.setPageNo(empParam.getPage());
        empQuery.setPageSize(empParam.getRows());
        EmpQuery.Criteria empQueryCriteria = empQuery.createCriteria();

        if (null!= empParam.getUsername()){
            empQueryCriteria.andUsernameLike("%"+empParam.getUsername()+"%");
        }
        if (null!= empParam.getAddress()){
            empQueryCriteria.andAddressLike("%"+empParam.getAddress()+"%");
        }
        if (null!=empParam.getGender() && (0== empParam.getGender() || 1== empParam.getGender())){
            empQueryCriteria.andGenderEqualTo(empParam.getGender());
        }
        if (null!= empParam.getTele()){
            empQueryCriteria.andTeleLike("%"+empParam.getTele()+"%");
        }
        if (null!= empParam.getEmail()){
            empQueryCriteria.andEmailLike("%"+empParam.getEmail()+"%");
        }
        if (null!= empParam.getName()){
            empQueryCriteria.andNameLike("%"+empParam.getName()+"%");
        }
        if (null!= empParam.getDepuuid()){
            empQueryCriteria.andDepuuidEqualTo(empParam.getDepuuid());
        }
        if (null!= empParam.getBirthdayQueryStart()){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = simpleDateFormat.parse(empParam.getBirthdayQueryStart());
            empQueryCriteria.andBirthdayGreaterThanOrEqualTo(data);
        }
        if (null!= empParam.getBirthdayQueryEnd()){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = simpleDateFormat.parse(empParam.getBirthdayQueryEnd());
            empQueryCriteria.andBirthdayLessThanOrEqualTo(data);
        }
        return empQuery;
    }

}
