package erp.bean.good;

import java.io.Serializable;

public class Goods implements Serializable {
    /**
     * 商品编号
     */
    private Long uuid;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 产地
     */
    private String origin;

    /**
     * 厂家
     */
    private String producer;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 进货价格
     */
    private Double inprice;

    /**
     * 出货价格
     */
    private Double outprice;

    /**
     * 商品类型
     */
    private Long goodstypeuuid;

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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer == null ? null : producer.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Double getInprice() {
        return inprice;
    }

    public void setInprice(Double inprice) {
        this.inprice = inprice;
    }

    public Double getOutprice() {
        return outprice;
    }

    public void setOutprice(Double outprice) {
        this.outprice = outprice;
    }

    public Long getGoodstypeuuid() {
        return goodstypeuuid;
    }

    public void setGoodstypeuuid(Long goodstypeuuid) {
        this.goodstypeuuid = goodstypeuuid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", name=").append(name);
        sb.append(", origin=").append(origin);
        sb.append(", producer=").append(producer);
        sb.append(", unit=").append(unit);
        sb.append(", inprice=").append(inprice);
        sb.append(", outprice=").append(outprice);
        sb.append(", goodstypeuuid=").append(goodstypeuuid);
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
        Goods other = (Goods) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getOrigin() == null ? other.getOrigin() == null : this.getOrigin().equals(other.getOrigin()))
            && (this.getProducer() == null ? other.getProducer() == null : this.getProducer().equals(other.getProducer()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getInprice() == null ? other.getInprice() == null : this.getInprice().equals(other.getInprice()))
            && (this.getOutprice() == null ? other.getOutprice() == null : this.getOutprice().equals(other.getOutprice()))
            && (this.getGoodstypeuuid() == null ? other.getGoodstypeuuid() == null : this.getGoodstypeuuid().equals(other.getGoodstypeuuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getOrigin() == null) ? 0 : getOrigin().hashCode());
        result = prime * result + ((getProducer() == null) ? 0 : getProducer().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getInprice() == null) ? 0 : getInprice().hashCode());
        result = prime * result + ((getOutprice() == null) ? 0 : getOutprice().hashCode());
        result = prime * result + ((getGoodstypeuuid() == null) ? 0 : getGoodstypeuuid().hashCode());
        return result;
    }
}