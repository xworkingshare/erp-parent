package com.xxx.erp.common.globalexceptionHandler;

import com.xxx.erp.common.threaddata.ThreadLocalData;
import com.xxx.erp.common.util.JackSonUtils;
import com.xxx.erp.common.web.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName: AsyncHandlerExceptionResolver
 * @Description: 全局异常处理器（异步）
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  1:20
 * @Version: 1.0
 **/
@Component
public class AsyncHandlerExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(AsyncHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {



        if(e instanceof TaskRejectedException){
            logger.error("线程池已满",e);
        }else {
            logger.error("未知异常!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!",e);
        }

        ThreadLocal<Map<String, Object>> threadLocal = ThreadLocalData.getThreadLocal(null);
        Map<String, Object> stringObjectMap = threadLocal.get();
        stringObjectMap.put("success", false);
        stringObjectMap.put("errorMessage", "系统异常1111111111111111111111");
        ResponseUtils.renderJson(httpServletResponse, JackSonUtils.objectToJson(stringObjectMap));

        return null;
    }
}