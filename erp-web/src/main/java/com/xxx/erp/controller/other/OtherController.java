package com.xxx.erp.controller.other;

import com.xxx.erp.common.constant.ConstantData;
import com.xxx.erp.common.web.session.ISessionProvider;
import com.xxx.erp.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: OtherController
 * @Description: Controller层的其他公共操作
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  18:34
 * @Version: 1.0
 **/
@Controller
@RequestMapping
public class OtherController extends BaseController{


    @Autowired
    ISessionProvider sessionProvider;

    /**
     *@MethodName： toIndexPage
     *@Description： 重定向到登录页
     *@Params：[]
     *@ParamComment：
     *@Return：java.lang.String
     *@Author ：谢万清
     *@CreateTime ：2018/12/4  14:50
     *@Version： 1.0
     */
    @GetMapping("/index/to_indexpage")
    public String toIndexPage() {
        return "redirect:/index.html";
    }


    @GetMapping(value = "/index/get_emp_from_session", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getEmpFromSession(HttpServletRequest request, HttpServletResponse response){

        start();
        String emp = sessionProvider.getAttribute(request, response, ConstantData.SESSION_EMP);

        if (emp!=null){
            isSuccess(true);
            setData(emp);
        }else{
            isSuccess(false);
            setErrorMessage("当前尚未登录");
        }

        return endGetMap();
    }
}
