package com.xxx.erp.common.threaddata;

import java.util.Map;

/**
 * @ClassName: ThreadLocalData  单例模式
 * @Description: 获取当前线程的Threadlocal对象
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  1:37
 * @Version: 1.0
 **/
public class ThreadLocalData {

    private  static   ThreadLocal<Map<String, Object>> threadLocal ;

    private ThreadLocalData(){

    }

    public static synchronized  ThreadLocal<Map<String, Object>>  getThreadLocal( ThreadLocal<Map<String, Object>>
                                                                                threadLocal  ){
        if(ThreadLocalData.threadLocal==null){
            ThreadLocalData.threadLocal = threadLocal;
        }

        return ThreadLocalData.threadLocal ;
    }


}
