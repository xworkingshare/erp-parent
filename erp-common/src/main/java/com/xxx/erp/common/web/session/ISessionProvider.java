package com.xxx.erp.common.web.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Seesion提供类
 * @author lx
 *
 */
public interface ISessionProvider {

	//面向接口编程
	
	//设置用户  Key value  Object 本地Sessio  远程Session  
	public void setAttributeForUser(HttpServletRequest request, HttpServletResponse response, String name, String value);

	//设置验证码
	public void setAttributeForCode(HttpServletRequest request, HttpServletResponse response, String name, String value);

	//获取Session中值
	public String getAttribute(HttpServletRequest request, HttpServletResponse response, String name);
	

	//获取SessionID  JSESSIONID
	public String getSessionId(HttpServletRequest request, HttpServletResponse response);

	//注销登陆
	public Long invalidateSession(HttpServletRequest request, HttpServletResponse response,String name);
	
}
