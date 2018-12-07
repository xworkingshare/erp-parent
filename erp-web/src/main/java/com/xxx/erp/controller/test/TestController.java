package com.xxx.erp.controller.test;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.common.web.ResponseUtils;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.dep.IDepService;
import com.xxx.erp.service.test.ITestService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: TestController
 * @Description: controller层测试类
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  2:34
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/test")
public class TestController extends BaseController{

    @Autowired
    ITestService testService;

    @Autowired
    IDepService depService;

    /**
     *@MethodName： getDepList
     *@Description： 测试手动 json序列化 返回；
     *@Params：[response]
     *@ParamComment： 
     *@Return：void
     *@Author ：谢万清
     *@CreateTime ：2018/12/4  12:42
     *@Version： 1.0
     */
    @RequestMapping("/deplist")
    public void getDepList(HttpServletResponse response) throws Exception {

        List<Dep> depList = depService.getList(null);
        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(depList);
        ResponseUtils.renderJson(response, valueAsString);
    }

    /**
     *@MethodName： getDepList2
     *@Description： 测试 responsebody 注解的 json序列化 返回
     *@Params：[]
     *@ParamComment： 
     *@Return：java.util.List<com.xxx.erp.bean.dep.Dep>
     *@Author ：谢万清
     *@CreateTime ：2018/12/4  12:43
     *@Version： 1.0
     */
    @RequestMapping("/deplist2")
    @ResponseBody
    public List<Dep> getDepList2() throws Exception {

        List<Dep> depList = depService.getList(null);

        return depList;

    }

    @RequestMapping("/test_transaction/{tele1}/{tele2}")
    @ResponseBody
    public Object testTransaction(@PathVariable("tele1") String tele1, @PathVariable("tele2") String tele2) throws Exception{

        start();
        int affcetRows = testService.testTransaction(tele1, tele2);
        if(1==affcetRows){
            isSuccess(true);
            setData(affcetRows);
        }else {
            isSuccess(false);
            setErrorMessage("操作失败，业务异常！");
        }

        return endGetMap();
    }


}
