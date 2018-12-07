package com.xxx.erp.controller.login;

import com.xxx.erp.bean.emp.Emp;
import com.xxx.erp.bean.emp.EmpQuery;
import com.xxx.erp.common.constant.ConstantData;
import com.xxx.erp.common.util.JackSonUtils;
import com.xxx.erp.common.web.session.ISessionProvider;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.emp.IEmpService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: LoginController
 * @Description: 登录操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  12:35
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    ISessionProvider sessionProvider;

    @Autowired
    IEmpService empService;

    /**
     * @MethodName： toLoginPage
     * @Description： 重定向到登录页
     * @Params：[]
     * @ParamComment：
     * @Return：java.lang.String
     * @Author ：谢万清
     * @CreateTime ：2018/12/4  14:50
     * @Version： 1.0
     */
    @GetMapping("/to_loginpage")
    public String toLoginPage() {
        return "redirect:/login.jsp";
    }


    /**
     * @MethodName： loginCheck
     * @Description： 登录认证校验
     * @Params：[userName, pwd]
     * @ParamComment：
     * @Return：java.lang.Object
     * @Author ：谢万清
     * @CreateTime ：2018/12/4  14:55
     * @Version： 1.0
     */
    @PostMapping(value = "/login_check", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object loginCheck(String userName, String pwd, HttpServletRequest request, HttpServletResponse response) throws
        Exception {
        start();

        EmpQuery empQuery = new EmpQuery();
        EmpQuery.Criteria empQueryCriteria = empQuery.createCriteria();

        Md5Hash md5Hash = new Md5Hash(pwd, ConstantData.SHIRO_MD5_SALT, 2);
        String pwdMd5 = md5Hash.toString();

        empQueryCriteria.andUsernameEqualTo(userName).andPwdEqualTo(pwdMd5);
        List<Emp> empList = empService.getList(empQuery);

        if (empList.isEmpty()) {
            isSuccess(false);
            setErrorMessage("用户名或者密码错误！");

        } else {
            isSuccess(true);
            setData("登录认证通过！");
            //将用户信息存入到session
            sessionProvider.setAttributeForUser(request, response, ConstantData.SESSION_EMP, JackSonUtils.objectToJson(empList
                .get(0)));

        }

        return endGetMap();
    }


    /**
     * @MethodName： loginout
     * @Description： 注销退出
     * @Params：[]
     * @ParamComment：
     * @Return：Objcet
     * @Author ：谢万清
     * @CreateTime ：2018/12/6  15:23
     * @Version： 1.0
     */
    @GetMapping(value = "/loginout", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object loginOut(HttpServletRequest request) {
        start();
        Long result = sessionProvider.invalidateSession(request, null, null);

        if (result > 0) {
            isSuccess(true);
            setData(result);

        }else{
            isSuccess(false);
            setErrorMessage("注销失败");
        }

        return endGetMap();
    }

}
