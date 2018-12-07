package com.xxx.erp.common.junit;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * @ClassName: MyTest
 * @Description: 单元测试
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  15:39
 * @Version: 1.0
 **/
public class MyTest {

    @Test
    public void TestMd5Hash(){
        Md5Hash md5Hash = new Md5Hash("aaaaaa", "hello", 2);
        System.out.println(md5Hash.toString());
        System.out.println(md5Hash.toString().length());
    }
}
