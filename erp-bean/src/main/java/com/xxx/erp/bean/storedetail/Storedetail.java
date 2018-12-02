package com.xxx.erp.bean.storedetail;

import java.io.Serializable;

public class Storedetail implements Serializable {
    /**
     * ID
     */
    private Long uuid;

    /**
     * 仓库ID
     */
    private Long storeuuid;

    /**
     * 商品ID
     */
    private Long goodsuuid;

    /**
     * 库存数量
     */
    private Integer num;

    private static final long serialVersionUID = 1L;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", storeuuid=").append(storeuuid);
        sb.append(", goodsuuid=").append(goodsuuid);
        sb.append(", num=").append(num);
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
        Storedetail other = (Storedetail) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getStoreuuid() == null ? other.getStoreuuid() == null : this.getStoreuuid().equals(other.getStoreuuid()))
            && (this.getGoodsuuid() == null ? other.getGoodsuuid() == null : this.getGoodsuuid().equals(other.getGoodsuuid()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getStoreuuid() == null) ? 0 : getStoreuuid().hashCode());
        result = prime * result + ((getGoodsuuid() == null) ? 0 : getGoodsuuid().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        return result;
    }
}