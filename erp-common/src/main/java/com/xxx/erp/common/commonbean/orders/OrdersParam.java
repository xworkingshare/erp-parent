package com.xxx.erp.common.commonbean.orders;

import com.xxx.erp.bean.orders.Orders;

/**
 * @ClassName: OrdersParam
 * @Description: 继承CommonParamWithPageBean类的，专门封装Orders参数的类型
 * @Author: 谢万清
 * @CreateTime: 2018/12/8  16:40
 * @Version: 1.0
 **/
public class OrdersParam extends Orders{

    private int page;
    private int rows;


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
