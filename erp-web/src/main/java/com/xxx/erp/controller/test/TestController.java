package com.xxx.erp.controller.test;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.common.web.ResponseUtils;
import com.xxx.erp.service.dep.IDepService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: TestController
 * @Description: controller层测试类
 * @Author: 谢万清
 * @CreateTime: 2018/12/3  2:34
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    IDepService depService;

    @RequestMapping("/deplist")
    public void getDepList(HttpServletResponse response) throws Exception {

        List<Dep> depList = depService.getList(null);
        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(depList);
        ResponseUtils.renderJson(response, valueAsString);
    }

    @RequestMapping("/deplist2")
    @ResponseBody
    public List<Dep> getDepList2() throws Exception {

        List<Dep> depList = depService.getList(null);

        return depList;

    }


}
