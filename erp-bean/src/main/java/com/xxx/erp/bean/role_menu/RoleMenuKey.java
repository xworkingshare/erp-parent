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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RoleMenuKey other = (RoleMenuKey) that;
        return (this.getRoleuuid() == null ? other.getRoleuuid() == null : this.getRoleuuid().equals(other.getRoleuuid()))
            && (this.getMenuuuid() == null ? other.getMenuuuid() == null : this.getMenuuuid().equals(other.getMenuuuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleuuid() == null) ? 0 : getRoleuuid().hashCode());
        result = prime * result + ((getMenuuuid() == null) ? 0 : getMenuuuid().hashCode());
        return result;
    }
}