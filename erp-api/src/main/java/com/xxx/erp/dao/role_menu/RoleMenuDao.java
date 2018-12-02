package com.xxx.erp.dao.role_menu;

import com.xxx.erp.bean.role_menu.RoleMenuKey;
import com.xxx.erp.bean.role_menu.RoleMenuQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuDao {
    int countByExample(RoleMenuQuery example);

    int deleteByExample(RoleMenuQuery example);

    int deleteByPrimaryKey(RoleMenuKey key);

    int insert(RoleMenuKey record);

    int insertSelective(RoleMenuKey record);

    List<RoleMenuKey> selectByExample(RoleMenuQuery example);

    int updateByExampleSelective(@Param("record") RoleMenuKey record, @Param("example") RoleMenuQuery example);

    int updateByExample(@Param("record") RoleMenuKey record, @Param("example") RoleMenuQuery example);
}