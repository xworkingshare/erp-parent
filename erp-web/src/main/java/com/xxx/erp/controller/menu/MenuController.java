package com.xxx.erp.controller.menu;

import com.xxx.erp.bean.emp.Emp;
import com.xxx.erp.bean.menu.Menu;
import com.xxx.erp.common.constant.ConstantData;
import com.xxx.erp.common.util.JackSonUtils;
import com.xxx.erp.common.web.session.ISessionProvider;
import com.xxx.erp.controller.base.BaseController;
import com.xxx.erp.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: MenuController
 * @Description: Menu菜单操作 Controller层
 * @Author: 谢万清
 * @CreateTime: 2018/12/7  0:51
 * @Version: 1.0
 **/
@Controller
@RequestMapping("menu")
public class MenuController extends BaseController{

    @Autowired
    IMenuService menuService;

    @Autowired
    ISessionProvider sessionProvider;


    @GetMapping(value = "/getSelfWithChildren", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getSelfWithChildren(HttpServletRequest request, HttpServletResponse response){
        start();

        //自关联查询全局所有菜单nemu
        Menu bigMenu = menuService.getSelfWithChildrenByMenuid("-1");

        //获取session中的emp
        String empJsonString = sessionProvider.getAttribute(request, response, ConstantData.SESSION_EMP);
        Emp emp = JackSonUtils.jsonToPojo(empJsonString, Emp.class);

        //根据emp中的uuid，获取它的专有的所有menu
        List<Menu> menuList = menuService.getMenusByEmpUUid(emp.getUuid().toString());

        //构建当前登录emp，个人的menu树
        Menu newBigMenu = bigMenu.copyContentWithoutChildren(bigMenu);
        for (Menu menu1 : bigMenu.getMenus()) {
            Menu  newMenu1 = menu1.copyContentWithoutChildren(menu1);

            for (Menu menu2 : menu1.getMenus()) {
                Menu  newMenu2 = menu2.copyContentWithoutChildren(menu2);
                if (menuList.contains(newMenu2)){
                    newMenu1.getMenus().add(newMenu2);
                }

            }

            if (newMenu1.getMenus().size()>0){
                newBigMenu.getMenus().add(newMenu1);
            }
        }

        setData(newBigMenu);
        isSuccess(true);
        return endGetMap();
    }

}
