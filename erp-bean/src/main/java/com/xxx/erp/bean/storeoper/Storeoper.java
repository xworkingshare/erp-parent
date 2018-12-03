package com.xxx.erp.bean.storeoper;

import java.io.Serializable;
import java.util.Date;

public class Storeoper implements Serializable {
    /**
     * ID
     */
    private Long uuid;

    /**
     * 员工ID
     */
    private Long empuuid;

    /**
     * 操作事件
     */
    private Date opertime;

    /**
     * 仓库ID
     */
    private Long storeuuid;

    /**
     * 商品ID
     */
    private Long goodsuuid;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 出入库标记
     */
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(Long empuuid) {
        this.empuuid = empuuid;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    public Long getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Long storeuuid) {
        this.storeuuid = storeuuid;
    }

    public Long getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(Long goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", empuuid=").append(empuuid);
        sb.append(", opertime=").append(opertime);
        sb.append(", storeuuid=").append(storeuuid);
        sb.append(", goodsuuid=").append(goodsuuid);
        sb.append(", num=").append(num);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}