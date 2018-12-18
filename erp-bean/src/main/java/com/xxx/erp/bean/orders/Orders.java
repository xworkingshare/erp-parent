package com.xxx.erp.bean.orders;

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


    private  String creatername;        //下单员
    private  String checkername;       //审查员
    private  String startername;        //采购员
    private  String endername;          //库管员

    private String suppliername;       //供应商名称

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public String getCreatername() {
        return creatername;
    }

    public void setCreatername(String creatername) {
        this.creatername = creatername;
    }

    public String getCheckername() {
        return checkername;
    }

    public void setCheckername(String checkername) {
        this.checkername = checkername;
    }

    public String getStartername() {
        return startername;
    }

    public void setStartername(String startername) {
        this.startername = startername;
    }

    public String getEndername() {
        return endername;
    }

    public void setEndername(String endername) {
        this.endername = endername;
    }


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
}