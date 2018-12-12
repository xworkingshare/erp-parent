package com.xxx.erp.bean.emp;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {
    /**
     * 员工编号
     */
    private Long uuid;

    /**
     * 登陆名称
     */
    private String username;

    /**
     * 登陆密码
     */
    private String pwd;

    /**
     * 姓名
     */
    private String name;

    /**
     * E-mail
     */
    private String email;

    /**
     * 电话
     */
    private String tele;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 地址
     */
    private String address;

    /**
     * 出生年月日
     */
    private Date birthday;

    /**
     * 部门编号
     */
    private Long depuuid;

    //部门名称
    private String depName;

    private static final long serialVersionUID = 1L;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele == null ? null : tele.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getDepuuid() {
        return depuuid;
    }

    public void setDepuuid(Long depuuid) {
        this.depuuid = depuuid;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", username=").append(username);
        sb.append(", pwd=").append(pwd);
        sb.append(", name=").append(name);
        sb.append(", email=").append(email);
        sb.append(", tele=").append(tele);
        sb.append(", gender=").append(gender);
        sb.append(", address=").append(address);
        sb.append(", birthday=").append(birthday);
        sb.append(", depuuid=").append(depuuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}