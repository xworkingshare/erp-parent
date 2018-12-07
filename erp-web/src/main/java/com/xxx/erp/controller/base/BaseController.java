package com.xxx.erp.controller.base;


import com.xxx.erp.common.threaddata.ThreadLocalData;
import com.xxx.erp.common.util.JackSonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一做json返回，固定代码抽取;
 * 对象转为json串的工具，使用JackSon
 *
 * @author xwoking
 */
public class BaseController {

    public static ThreadLocal<Map<String, Object>> threadLocal ;

    public BaseController() {
        if(null == threadLocal){
            this.threadLocal = new ThreadLocal<>();
            ThreadLocalData.getThreadLocal(this.threadLocal);
        }
    }


    /**
     * 方法1：start()
     * 给当前请求线程，在ThreadLocal对象中，绑定1个Map对象，
     * 专门用于给该请求线程，存放所有需要返回给浏览器的数据；
     */
    public void start() {
        Map<String, Object> resultMap = new HashMap<>();
        threadLocal.set(resultMap);
    }

    /**
     * 方法2：end()
     * 从在ThreadLocal对象中，获取给当前请求线程绑定那个Map对象，
     * 并转换为JSON字符串，返回；
     *
     * @return
     */
    public String end() {
        Map<String, Object> map = threadLocal.get();
        threadLocal.remove();
        String objectToJson = JackSonUtils.objectToJson(map);

        return objectToJson;
    }

    /**
     * 方法2+：endGetMap()
     * 从在ThreadLocal对象中，获取给当前请求线程绑定那个Map对象，
     * 并转换为JSON字符串，返回；
     *
     * @return
     */
    public Map<String, Object> endGetMap() {
        Map<String, Object> map = threadLocal.get();
        threadLocal.remove();

        return map;
    }

    /**
     * 方法3：向当前请求线程，在ThreadLocal对象中绑定的Map对象中，
     * 设置后台是否抛异常的标志位：success；
     *
     * @param success
     */
    public void isSuccess(boolean success) {
        threadLocal.get().put("success", success);
    }

    /**
     * 方法4：如果后台抛异常了，则向当前请求线程，在ThreadLocal对象中绑定的Map对象中，
     * 设置异常信息：errorMessage；
     *
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        threadLocal.get().put("errorMessage", errorMessage);
    }

    /**
     * 方法4：向当前请求线程，在ThreadLocal对象中绑定的Map对象中，
     * 设置正常响应的数据：data
     *
     * @param data
     */
    public void setData(Object data) {
        threadLocal.get().put("data", data);
    }

}
