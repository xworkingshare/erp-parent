package com.xxx.erp.common.global.servletcontext;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletContext;

/**
 * @ClassName: CacheServletContestProvide
 * @Description: 从redis中，获取项目上下文容器中的值
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  17:55
 * @Version: 1.0
 **/
//@Component("servletContextProvider")
public class CacheServletContestProvide implements  IServletContextProvider {

    @Autowired
    private Jedis jedis;
    //失效时间
    private Integer exp = 30;  //-1表示永不过期


    //设置失效时间
    public void setExp(Integer exp) {
        this.exp = exp;
    }



    @Override
    public Object getAttribute(ServletContext servletContext, String key) {
        return jedis.get(key);

    }

    @Override
    public void setAttribute(ServletContext servletContext, String key, Object value) {

        jedis.set(key, value.toString());

        //设置失效时间
        jedis.expire(key,exp);

    }

    @Override
    public void removeAttribute(ServletContext servletContext, String key) {
        jedis.del(key);
    }


}
