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
}