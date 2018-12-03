package com.xxx.erp.bean.menu;

import java.io.Serializable;

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
    private String pid;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuid=").append(menuid);
        sb.append(", menuname=").append(menuname);
        sb.append(", icon=").append(icon);
        sb.append(", url=").append(url);
        sb.append(", pid=").append(pid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}