package com.xxx.erp.common.web.listener;

import com.xxx.erp.common.constant.ConstantData;
import com.xxx.erp.common.global.servletcontext.IServletContextProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener监听ServletContext对象的创建和销毁：
 * 	ServletContext对象在服务器启动时加载项目时来创建这个对象。
 *  ServletContext对象在服务器关闭，或卸载项目时销毁这个对象。
 * @author zhangyu
 *
 */
@Component
public class StartUpAndShutDownSystemListener implements ServletContextListener {


	@Override
	public void contextDestroyed(ServletContextEvent sce) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        IServletContextProvider servletContextProvider = (IServletContextProvider)webApplicationContext.getBean("servletContextProvider");

        ServletContext servletContext = sce.getServletContext();
        servletContextProvider.removeAttribute(servletContext, ConstantData.APP_PATH);
        System.out.println("项目启动监听器__StartUpAndShutDownSystemListener类，contextDestroyed方法启动中 ...");

	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//1.在父亲启动过程中，将当前项目上下文路径存放到application域中，给页面使用，
		//好处：    
		//这样在页面上，就不用把项目名写死了，便于随时更改项目名，每次加载页面，都可以动态从项目中获取项目名；
		
		ServletContext servletContext = sce.getServletContext();
		String contextPath = servletContext.getContextPath();

        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        IServletContextProvider servletContextProvider = (IServletContextProvider)webApplicationContext.getBean("servletContextProvider");
        servletContextProvider.setAttribute(servletContext, ConstantData.APP_PATH, contextPath);
		
		System.out.println("项目启动监听器__StartUpAndShutDownSystemListener类，contextInitialized方法启动中 ...");
	}



}
