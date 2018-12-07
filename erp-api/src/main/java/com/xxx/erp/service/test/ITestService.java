package com.xxx.erp.service.test;

/**
* @ClassName:   ITestService
* @Description:  测试 Service层接口
*                                 
* @Author:           谢万清
* @CreateTime:   2018/12/4  12:50
* @Version:          1.0   
**/
public interface ITestService {
    
    /**
     *@MethodName： testTransaction
     *@Description： 事务测试类
     *@Params：[tele1, tele2]
     *@ParamComment： 
     *@Return：int
     *@Author ：谢万清
     *@CreateTime ：2018/12/4  13:15
     *@Version： 1.0
     */
    public int testTransaction(String tele1, String tele2) throws Exception;
}
