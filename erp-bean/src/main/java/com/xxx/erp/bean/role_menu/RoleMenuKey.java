package com.xxx.erp.bean.role_menu;

import java.io.Serializable;

public class RoleMenuKey implements Serializable {
    /**
     * 角色ID
     */
    private Long roleuuid;

    /**
     * 菜单ID
     */
    private Long menuuuid;

    private static final long serialVersionUID = 1L;

    public Long getRoleuuid() {
        return roleuuid;
    }

    public void setRoleuuid(Long roleuuid) {
        this.roleuuid = roleuuid;
    }

    public Long getMenuuuid() {
        return menuuuid;
    }

    public void setMenuuuid(Long menuuuid) {
        this.menuuuid = menuuuid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleuuid=").append(roleuuid);
        sb.append(", menuuuid=").append(menuuuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}