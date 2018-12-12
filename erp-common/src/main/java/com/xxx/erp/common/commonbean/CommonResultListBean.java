package com.xxx.erp.common.commonbean;

import java.util.List;

/**
 * @ClassName: CommonResultListBean
 * @Description: 通用的列表返回bean对象
 * @Author: 谢万清
 * @CreateTime: 2018/12/8  1:30
 * @Version: 1.0
 **/
public class CommonResultListBean<T> {

    private List<T> rows;
    private long total;


    public CommonResultListBean(List<T> rows, long total){
        this.rows = rows;
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
