package com.xxx.erp.common.web.session;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Redis 远程
 * @author lx
 *
 */
//@Component("sessionProvider")
public class CacheSessionProvider implements ISessionProvider{
	
	@Autowired
	private Jedis jedis;
	//失效时间
	private Integer exp = 30;


	//设置失效时间
	public void setExp(Integer exp) {
		this.exp = exp;
	}



    //从session中获取用户信息
	@Override
	public void setAttributeForUser(HttpServletRequest request,
			HttpServletResponse response, String name, String value) {

		// 用户名 ： 用户ID
		jedis.set(name + ":" + getSessionId(request,response), value);
		//设置失效时间
		jedis.expire(name + ":" + getSessionId(request,response), exp*60);
		
	}

	//从session中获取验证码
	@Override
	public void setAttributeForCode(HttpServletRequest request,
			HttpServletResponse response, String name, String value) {

		jedis.set(name + ":" + getSessionId(request,response), value);
		//设置失效时间
		jedis.expire(name + ":" + getSessionId(request,response), 60);
	}

	@Override
	public String getAttribute(HttpServletRequest request,
			HttpServletResponse response, String name) {

		return jedis.get(name + ":" + getSessionId(request,response));
	}

	@Override
	public String getSessionId(HttpServletRequest request,
			HttpServletResponse response) {

	    //request.getSession().getId()// 新机器 都变
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			//name : JESSIONID
			if("BJSESSIONID".equals(cookie.getName())){
				return cookie.getValue();//自定义的32位字段串
			}
		}

		//自定义的32位字段串
		String sessionId = UUID.randomUUID().toString().replaceAll("-", "");
		//保存在Cookie中一份 为了其它机器获取时 拿到此ID
		Cookie cookie = new Cookie("BJSESSIONID",sessionId);
		//设置路径 request是否带着此Cookie 取决于 此Cookie的路径
		cookie.setPath("/");
		//设置时间  默认时间 （关闭浏览器就消失） -1
		response.addCookie(cookie);

		return sessionId;
	}

	@Override
	public Long invalidateSession(HttpServletRequest request, HttpServletResponse response, String name) {

        Long result = jedis.del(name + ":" + getSessionId(request, response));
        return result;
	}

}
