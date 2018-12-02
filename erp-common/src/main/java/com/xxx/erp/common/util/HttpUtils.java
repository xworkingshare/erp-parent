package com.xxx.erp.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 模拟 浏览器 
 * @author lx
 *
 */
public class HttpUtils {

	//浏览器
	public static void httpSender(Long id){
		//New浏览器
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		
		//提交一个Form表单
		HttpPost  httpPost = new HttpPost("http://localhost:8090/staticpage/index.cms");
		
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		
		parameters.add(new BasicNameValuePair("id", id + ""));
		
		try {
			HttpEntity entity = new UrlEncodedFormEntity(parameters);
			
			//Key value
			httpPost.setEntity(entity);
			
			CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
			//返回东西
			HttpEntity entity2 = response.getEntity();
			
			String string = EntityUtils.toString(entity2,"UTF-8");
			
			System.out.println(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
