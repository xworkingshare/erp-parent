package com.xxx.erp.common.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 发送ＪＳＯＮ
 * xml 
 * text
 * @author lx
 *
 */
public class ResponseUtils {
	
	
	
	//发文本
	public static void renderText(HttpServletResponse response,String text){
		render(response, "text/plain", text);
	}
	//发xml
	public static void renderXml(HttpServletResponse response,String text){
		render(response, "text/xml", text);
	}
	//发JSON
	public static void renderJson(HttpServletResponse response,String text){
		render(response, "application/json;charset=UTF-8", text);
	}

	//发
	public static void render(HttpServletResponse response,String type,String text){
		//"application/json;charset=UTF-8"
		response.setContentType(type);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
