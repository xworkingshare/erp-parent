package erp.bean.orders;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    /**
     * ID
     */
    private Long uuid;

    /**
     * 订单编号
     */
    private String ordernum;

    /**
     * 生成日期
     */
    private Date createtime;

    /**
     * 检查日期
     */
    private Date checktime;

    /**
     * 开始日期
     */
    private Date starttime;

    /**
     * 结束日期
     */
    private Date endtime;

    /**
     * 订单类型
     */
    private Integer ordertype;

    /**
     * 下单员
     */
    private Long creater;

    /**
     * 审查员
     */
    private Long checker;

    /**
     * 采购员
     */
    private Long starter;

    /**
     * 库管员
     */
    private Long ender;

    /**
     * 供应商ID
     */
    private Long supplieruuid;

    /**
     * 总数量
     */
    private Integer totalnum;

    /**
     * 总价格
     */
    private Double totalprice;

    /**
     * 订单状态
     */
    private String state;

    private static final long serialVersionUID = 1L;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Long getChecker() {
        return checker;
    }

    public void setChecker(Long checker) {
        this.checker = checker;
    }

    public Long getStarter() {
        return starter;
    }

    public void setStarter(Long starter) {
        this.starter = starter;
    }

    public Long getEnder() {
        return ender;
    }

    public void setEnder(Long ender) {
        this.ender = ender;
    }

    public Long getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(Long supplieruuid) {
        this.supplieruuid = supplieruuid;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
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
        sb.append(", ordernum=").append(ordernum);
        sb.append(", createtime=").append(createtime);
        sb.append(", checktime=").append(checktime);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", ordertype=").append(ordertype);
        sb.append(", creater=").append(creater);
        sb.append(", checker=").append(checker);
        sb.append(", starter=").append(starter);
        sb.append(", ender=").append(ender);
        sb.append(", supplieruuid=").append(supplieruuid);
        sb.append(", totalnum=").append(totalnum);
        sb.append(", totalprice=").append(totalprice);
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
        Orders other = (Orders) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getOrdernum() == null ? other.getOrdernum() == null : this.getOrdernum().equals(other.getOrdernum()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getChecktime() == null ? other.getChecktime() == null : this.getChecktime().equals(other.getChecktime()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getOrdertype() == null ? other.getOrdertype() == null : this.getOrdertype().equals(other.getOrdertype()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getChecker() == null ? other.getChecker() == null : this.getChecker().equals(other.getChecker()))
            && (this.getStarter() == null ? other.getStarter() == null : this.getStarter().equals(other.getStarter()))
            && (this.getEnder() == null ? other.getEnder() == null : this.getEnder().equals(other.getEnder()))
            && (this.getSupplieruuid() == null ? other.getSupplieruuid() == null : this.getSupplieruuid().equals(other.getSupplieruuid()))
            && (this.getTotalnum() == null ? other.getTotalnum() == null : this.getTotalnum().equals(other.getTotalnum()))
            && (this.getTotalprice() == null ? other.getTotalprice() == null : this.getTotalprice().equals(other.getTotalprice()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getOrdernum() == null) ? 0 : getOrdernum().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getOrdertype() == null) ? 0 : getOrdertype().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getChecker() == null) ? 0 : getChecker().hashCode());
        result = prime * result + ((getStarter() == null) ? 0 : getStarter().hashCode());
        result = prime * result + ((getEnder() == null) ? 0 : getEnder().hashCode());
        result = prime * result + ((getSupplieruuid() == null) ? 0 : getSupplieruuid().hashCode());
        result = prime * result + ((getTotalnum() == null) ? 0 : getTotalnum().hashCode());
        result = prime * result + ((getTotalprice() == null) ? 0 : getTotalprice().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }
}