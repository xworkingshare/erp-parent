package com.xxx.erp.bean.emp;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.text.SimpleDateFormat;

/**
 * @ClassName: EmpResult
 * @Description: Emp查询结果类
 * @Author: 谢万清
 * @CreateTime: 2018/12/9  14:38
 * @Version: 1.0
 **/
public class EmpResult extends  Emp {

    public EmpResult(Emp emp){
        this.setAddress(emp.getAddress());
        this.setBirthday(emp.getBirthday());
        this.setDepName(emp.getDepName());
        this.setDepuuid(emp.getDepuuid());
        this.setEmail(emp.getEmail());
        this.setGender(emp.getGender());
        this.setName(emp.getName());
        this.setPwd(emp.getPwd());
        this.setTele(emp.getTele());
        this.setUsername(emp.getName());
        this.setUuid(emp.getUuid());
    }


    //重写父类的pwd字段，加上不json序列化的注解，防止员工列表查询时返回pwd到json串中；
    @JsonIgnore
    private String pwd;


    private  String birthdayString;

    public void setBirthdayString(String birthdayString) {
        this.birthdayString = birthdayString;
    }

    public String getBirthdayString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.format(this.getBirthday());
        return birthdayString;
    }

}
