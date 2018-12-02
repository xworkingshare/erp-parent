package com.xxx.erp.bean.emp_role;

import java.io.Serializable;

public class EmpRoleKey implements Serializable {
    /**
     * 员工编号
     */
    private Long empuuid;

    /**
     * 角色编号
     */
    private Long roleuuid;

    private static final long serialVersionUID = 1L;

    public Long getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(Long empuuid) {
        this.empuuid = empuuid;
    }

    public Long getRoleuuid() {
        return roleuuid;
    }

    public void setRoleuuid(Long roleuuid) {
        this.roleuuid = roleuuid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", empuuid=").append(empuuid);
        sb.append(", roleuuid=").append(roleuuid);
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
        EmpRoleKey other = (EmpRoleKey) that;
        return (this.getEmpuuid() == null ? other.getEmpuuid() == null : this.getEmpuuid().equals(other.getEmpuuid()))
            && (this.getRoleuuid() == null ? other.getRoleuuid() == null : this.getRoleuuid().equals(other.getRoleuuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmpuuid() == null) ? 0 : getEmpuuid().hashCode());
        result = prime * result + ((getRoleuuid() == null) ? 0 : getRoleuuid().hashCode());
        return result;
    }
}