package com.xxx.erp.common.global.servletcontext;

import javax.servlet.ServletContext;

/**
* @ClassName:   IServletContextProvider
* @Description:  封装 项目全局上下文 容器
*                                 
* @Author:           谢万清
* @CreateTime:   2018/12/4  17:37
* @Version:          1.0   
**/
public interface IServletContextProvider {

    /**
     *@MethodName： getAttribute
     *@Description： 从项目全局上下文 容器，获取对应 key的 value值
     *@Params：[request, key]
     *@ParamComment：
     *@Return：java.lang.String
     *@Author ：谢万清
     *@CreateTime ：2018/12/4  17:46
     *@Version： 1.0
     */
    public Object getAttribute(ServletContext servletContext, String key);

    /**
     *@MethodName： setAttribute
     *@Description： 从项目全局上下文 容器，设置key/value
     *@Params：[request, key, value]
     *@ParamComment：
     *@Return：void
     *@Author ：谢万清
     *@CreateTime ：2018/12/4  17:46
     *@Version： 1.0
     */
    public void setAttribute(ServletContext servletContext, String key, Object value);

    /**
     *@MethodName： removeAttribute
     *@Description： 从项目全局上下文 容器，删除key/value
     *@Params：[servletContext, key]
     *@ParamComment：
     *@Return：void
     *@Author ：谢万清
     *@CreateTime ：2018/12/4  18:25
     *@Version： 1.0
     */
    public void removeAttribute(ServletContext servletContext, String key);

}
