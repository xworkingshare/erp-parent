package com.xxx.erp.common.commonbean.emp;

import com.xxx.erp.bean.emp.Emp;

/**
 * @ClassName: EmpParam
 * @Description: 继承CommonParamWithPageBean类的，专门封装Emp参数的类型
 * @Author: 谢万清
 * @CreateTime: 2018/12/8  16:40
 * @Version: 1.0
 **/
public class EmpParam extends Emp{

    private int page;
    private int rows;

    //查询条件_生日范围的_开始生日日期
    private String birthdayQueryStart;

    //查询条件_生日范围的结束生日日期
    private String birthdayQueryEnd;

    //添加/修改框_提交的日期都是String类型，只要经过网络传输过来的都是String类型
    private  String birthdayString;

    public void setBirthdayString(String birthdayString) {
        this.birthdayString = birthdayString;
    }

    public String getBirthdayString() {
        return birthdayString;
    }

    public void setBirthdayQueryStart(String birthdayQueryStart) {
        this.birthdayQueryStart = birthdayQueryStart;
    }


    public String getBirthdayQueryStart() {
        return birthdayQueryStart;
    }

    public void setBirthdayQueryEnd(String birthdayQueryEnd) {
        this.birthdayQueryEnd = birthdayQueryEnd;
    }

    public String getBirthdayQueryEnd() {
        return birthdayQueryEnd;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }
}
