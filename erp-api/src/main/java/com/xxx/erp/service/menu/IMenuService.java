package com.xxx.erp.service.menu;

import com.xxx.erp.bean.menu.Menu;

import java.util.List;

/**
* @ClassName:   IMenuService
* @Description:  菜单Menu Service层接口
*                                 
* @Author:           谢万清
* @CreateTime:   2018/12/7  0:48
* @Version:          1.0   
**/
public interface IMenuService {

    /**
     *@MethodName： getSelfWithChildrenByMenuid
     *@Description： 对BaseResultMap添加children映射，完成多级自关联查询自动封装
     *@Params：[menuid]
     *@ParamComment：
     *@Return：com.xxx.erp.bean.menu.Menu
     *@Author ：谢万清
     *@CreateTime ：2018/12/7  0:46
     *@Version： 1.0
     */
    public Menu getSelfWithChildrenByMenuid(String menuid);


    /**
     *@MethodName： getMenusByEmpUUid
     *@Description： 根据　EMP的uuid，获取它的所有menu
     *@Params：[empuuid]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.menu.Menu
     *@Author ：谢万清
     *@CreateTime ：2018/12/7  12:40
     *@Version： 1.0
     */
    public List<Menu> getMenusByEmpUUid(String empuuid);

}
