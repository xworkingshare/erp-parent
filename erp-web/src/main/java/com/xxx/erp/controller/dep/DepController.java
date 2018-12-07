package com.xxx.erp.controller.dep;

import com.xxx.erp.bean.dep.Dep;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.dep.IDepService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @ClassName: DepController
 * @Description: 部门操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/4  0:38
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/dep")
public class DepController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DepController.class);

    @Autowired
    IDepService depService;


    @RequestMapping("/getOneById/{id}")
    @ResponseBody
    public Map<String, Object> getOneById(@PathVariable("id") Long id) throws Exception {

        logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        start();
        Dep dep = depService.get(id);
        isSuccess(true);
        setData(dep);
        Map<String, Object> resultMap = endGetMap();
        return resultMap;
    }

}
