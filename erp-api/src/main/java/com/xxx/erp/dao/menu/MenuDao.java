package com.xxx.erp.dao.menu;

import com.xxx.erp.bean.menu.Menu;
import com.xxx.erp.bean.menu.MenuQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    int countByExample(MenuQuery example);

    int deleteByExample(MenuQuery example);

    int deleteByPrimaryKey(String menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuQuery example);

    Menu selectByPrimaryKey(String menuid);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);


    /**
     *@MethodName： selectSelfWithChildrenByMenuid
     *@Description： 对BaseResultMap添加children映射，完成多级自关联查询自动封装
     *@Params：[menuid]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.menu.Menu
     *@Author ：谢万清
     *@CreateTime ：2018/12/7  0:49
     *@Version： 1.0
     */
    public Menu selectSelfWithChildrenByMenuid(@Param("menuid") String menuid);


    /**
     *@MethodName： selectMenusByEmpUuid
     *@Description： 根据　EMP的uuid，获取它的所有menu
     *@Params：[empuuid]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.menu.Menu
     *@Author ：谢万清
     *@CreateTime ：2018/12/7  12:43
     *@Version： 1.0
     */
    public List<Menu> selectMenusByEmpUuid (@Param("empuuid") String empuuid);

}