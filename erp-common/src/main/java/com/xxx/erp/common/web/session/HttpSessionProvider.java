package com.xxx.erp.common.web.session;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 本地Session
 * @author lx
 *
 */
@Component("sessionProvider")
public class HttpSessionProvider implements ISessionProvider {

	@Override
	public void setAttributeForUser(HttpServletRequest request,
			HttpServletResponse response, String name, String value) {

		HttpSession session = request.getSession();
		session.setAttribute(name, value);

	}

	@Override
	public void setAttributeForCode(HttpServletRequest request,
			HttpServletResponse response, String name, String value) {

		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}

	@Override
	public String getAttribute(HttpServletRequest request,
			HttpServletResponse response, String name) {

		// Cookie 中 取 JSESSIONID 对应的 Value
		//Session对象
		//有：返回此Session
		//没有：创建一个新的Session
		HttpSession session = request.getSession(false);
		if(null != session){
			return (String) session.getAttribute(name);
		}
		return null;
	}

	@Override
	public String getSessionId(HttpServletRequest request,
			HttpServletResponse response) {

		//request.getRequestedSessionId()
		return request.getSession().getId();
	}

	@Override
	public Long invalidateSession(HttpServletRequest request, HttpServletResponse response,String  name) {
		request.getSession().invalidate();
		return 1L;
	}

}
