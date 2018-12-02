package erp.bean.storeoper;

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
        Storeoper other = (Storeoper) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getEmpuuid() == null ? other.getEmpuuid() == null : this.getEmpuuid().equals(other.getEmpuuid()))
            && (this.getOpertime() == null ? other.getOpertime() == null : this.getOpertime().equals(other.getOpertime()))
            && (this.getStoreuuid() == null ? other.getStoreuuid() == null : this.getStoreuuid().equals(other.getStoreuuid()))
            && (this.getGoodsuuid() == null ? other.getGoodsuuid() == null : this.getGoodsuuid().equals(other.getGoodsuuid()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getEmpuuid() == null) ? 0 : getEmpuuid().hashCode());
        result = prime * result + ((getOpertime() == null) ? 0 : getOpertime().hashCode());
        result = prime * result + ((getStoreuuid() == null) ? 0 : getStoreuuid().hashCode());
        result = prime * result + ((getGoodsuuid() == null) ? 0 : getGoodsuuid().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}