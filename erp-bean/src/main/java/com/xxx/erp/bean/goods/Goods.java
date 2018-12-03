package com.xxx.erp.bean.goods;

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
}