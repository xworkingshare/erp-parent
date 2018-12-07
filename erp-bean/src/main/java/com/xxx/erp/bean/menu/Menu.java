package com.xxx.erp.bean.menu;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Menu implements Serializable {
    /**
     * 菜单ID
     */
    private String menuid;

    /**
     * 菜单名称
     */
    private String menuname;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 上级菜单ID
     */
    @JsonIgnore
    private String pid;

    /**
     * 子菜单
     */
    private List<Menu> menus;

    private static final long serialVersionUID = 1L;

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Menu{" +
            "menuid='" + menuid + '\'' +
            ", menuname='" + menuname + '\'' +
            ", icon='" + icon + '\'' +
            ", url='" + url + '\'' +
            ", pid='" + pid + '\'' +
            ", menus=" + menus +
            '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        return menuid.equals(menu.menuid);
    }

    @Override
    public int hashCode() {
        return menuid.hashCode();
    }

    /**
     *@MethodName： copyContentWithoutChildren
     *@Description： 不带children的，复制1个，Menu对象
     *@Params：[menu]
     *@ParamComment： 
     *@Return：com.xxx.erp.bean.menu.Menu
     *@Author ：谢万清
     *@CreateTime ：2018/12/7  13:11
     *@Version： 1.0
     */
    public Menu copyContentWithoutChildren(Menu oldMenu){

        Menu menu = new Menu();

        menu.setIcon(oldMenu.getIcon());
        menu.setUrl(oldMenu.getUrl());
        menu.setMenuid(oldMenu.getMenuid());
        menu.setMenuname(oldMenu.getMenuname());
        menu.setPid(oldMenu.getPid());
        menu.setMenus(new ArrayList<Menu>());

        return menu;

    }
}