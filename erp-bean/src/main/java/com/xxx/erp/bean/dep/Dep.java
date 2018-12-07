package com.xxx.erp.bean.dep;

import java.io.Serializable;

public class Dep implements Serializable {
    /**
     * 部门编号
     */
    private Long uuid;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 电话
     */
    private String tele;

    private static final long serialVersionUID = 1L;

    public Long getUuid() {
        return uuid;
    }


    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele == null ? null : tele.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", name=").append(name);
        sb.append(", tele=").append(tele);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}