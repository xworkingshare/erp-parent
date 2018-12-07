<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.xxx.erp.common.global.servletcontext.IServletContextProvider" %>
<%@ page import="com.xxx.erp.common.constant.ConstantData" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>ERP管理系统</title>
    <link rel="stylesheet" type="text/css" href="ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="ui/themes/icon.css">
    <script type="text/javascript" src="ui/jquery.min.js"></script>
    <script type="text/javascript" src="ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="ui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/form.js"></script>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
<%
    WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(application);
    IServletContextProvider servletContextProvider = (IServletContextProvider)webApplicationContext.getBean("servletContextProvider");
    String  appPath = servletContextProvider.getAttribute(application, ConstantData.APP_PATH).toString();
%>
    <script>
        $(function () {

            //从Spring容器中得到appPath变量
            localStorage.setItem("app_path","<%=appPath%>");

            //给登录按钮，绑定点击事件
            $('#loginButton').on('click',function() {
                var formdata = getFormData("loginform");

                $.ajax({
                    url:  localStorage.getItem("app_path")+'/login/login_check',
                    type: 'post',
                    dataType:'json',
                    data: formdata,
                    success: function (data) {
                        if (data.success == true) {
                            location.href = localStorage.getItem("app_path")+'/index/to_indexpage';
                        } else {
                            $.messager.alert("提示", data.errorMessage);
                        }

                    },
                    error:function() {
                        $.messager.alert("提示", "网络异常，请稍后再试");
                    }
                });

            })


            //给“记住我”，绑定点击事件
            $('#rememberMe').on("click", function () {
                $(this).toggleClass("selected");
            });

        });


    </script>

</head>
<body>
<div class='signup_container'>
    <div class="w-load">
        <div class="spin"></div>
    </div>
    <h1 class='signup_title'>ERP管理系统</h1>
    <div id="userInfo">
        <span style="float:left; margin-left:40px; height:200px; border:0px solid red"><img src='images/erp.jpg'
                                                                                            id='admin'/></span>
        <span style="float:left; margin-left:40px; height:200px; border:0px solid red">
            <div id="signup_forms" class="signup_forms clearfix">
                        <form class="signup_form_form" id="loginform" method="post">
                                <div class="form_row first_row">
                                    <label for="signup_name">请输入用户名</label>
                                    <input type="text" name="userName" placeholder="请输入用户名" id="signup_name"
                                           data-required="required">
                                </div>
                                <div class="form_row">
                                    <label for="signup_password">请输入密码</label>
                                    <input type="password" name="pwd" placeholder="请输入密码" id="signup_password"
                                           data-required="required">
                                </div>
                       </form>
            </div> 
            <div id="foo"></div>
                	<br/>      
        </span>
    </div>

    <div class="login-btn-set">
        <div class='rem' id="rememberMe">记住我</div>
        <a href='javascript:void(0)' class='login-btn' id="loginButton"></a></div>

</div>

</body>


</html>