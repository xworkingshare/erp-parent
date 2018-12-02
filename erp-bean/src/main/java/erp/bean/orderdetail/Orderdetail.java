package erp.bean.orderdetail;

import java.io.Serializable;
import java.util.Date;

public class Orderdetail implements Serializable {
    /**
     * ID
     */
    private Long uuid;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 价格
     */
    private Double price;

    /**
     * 金额
     */
    private Double money;

    /**
     * 商品ID
     */
    private Long goodsuuid;

    /**
     * 商品ID
     */
    private String goodsname;

    /**
     * 订单ID
     */
    private Long orderuuid;

    /**
     * 出入库时间
     */
    private Date endtime;

    /**
     * 库管员
     */
    private Long ender;

    /**
     * 仓库编号
     */
    private Long storeuuid;

    /**
     * 状态
     */
    private String state;

    private static final long serialVersionUID = 1L;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Long getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(Long goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Long getOrderuuid() {
        return orderuuid;
    }

    public void setOrderuuid(Long orderuuid) {
        this.orderuuid = orderuuid;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Long getEnder() {
        return ender;
    }

    public void setEnder(Long ender) {
        this.ender = ender;
    }

    public Long getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Long storeuuid) {
        this.storeuuid = storeuuid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", num=").append(num);
        sb.append(", price=").append(price);
        sb.append(", money=").append(money);
        sb.append(", goodsuuid=").append(goodsuuid);
        sb.append(", goodsname=").append(goodsname);
        sb.append(", orderuuid=").append(orderuuid);
        sb.append(", endtime=").append(endtime);
        sb.append(", ender=").append(ender);
        sb.append(", storeuuid=").append(storeuuid);
        sb.append(", state=").append(state);
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
        Orderdetail other = (Orderdetail) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getGoodsuuid() == null ? other.getGoodsuuid() == null : this.getGoodsuuid().equals(other.getGoodsuuid()))
            && (this.getGoodsname() == null ? other.getGoodsname() == null : this.getGoodsname().equals(other.getGoodsname()))
            && (this.getOrderuuid() == null ? other.getOrderuuid() == null : this.getOrderuuid().equals(other.getOrderuuid()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getEnder() == null ? other.getEnder() == null : this.getEnder().equals(other.getEnder()))
            && (this.getStoreuuid() == null ? other.getStoreuuid() == null : this.getStoreuuid().equals(other.getStoreuuid()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getGoodsuuid() == null) ? 0 : getGoodsuuid().hashCode());
        result = prime * result + ((getGoodsname() == null) ? 0 : getGoodsname().hashCode());
        result = prime * result + ((getOrderuuid() == null) ? 0 : getOrderuuid().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getEnder() == null) ? 0 : getEnder().hashCode());
        result = prime * result + ((getStoreuuid() == null) ? 0 : getStoreuuid().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }
}