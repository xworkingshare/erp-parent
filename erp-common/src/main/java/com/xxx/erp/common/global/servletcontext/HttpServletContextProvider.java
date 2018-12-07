package com.xxx.erp.common.global.servletcontext;


import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
* @ClassName:   HttpServletContextProvider
* @Description:  从Tomcat中，获取项目全局上下文容器
*                                 
* @Author:           谢万清
* @CreateTime:   2018/12/4  17:50
* @Version:          1.0   
**/
@Component("servletContextProvider")
public class HttpServletContextProvider  implements  IServletContextProvider{

    @Override
    public Object getAttribute(ServletContext servletContext, String key) {

        Object  value = servletContext.getAttribute(key);

        return value;

    }

    @Override
    public void setAttribute(ServletContext servletContext, String key, Object value) {

        servletContext.setAttribute(key,value);

    }

    @Override
    public void removeAttribute(ServletContext servletContext, String key) {
        servletContext.removeAttribute(key);
    }


}
