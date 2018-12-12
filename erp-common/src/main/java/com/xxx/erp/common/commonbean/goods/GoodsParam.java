package com.xxx.erp.common.commonbean.goods;

import com.xxx.erp.bean.goods.Goods;

/**
 * @ClassName: GoodsParam
 * @Description: 继承CommonParamWithPageBean类的，专门封装Goods参数的类型
 * @Author: 谢万清
 * @CreateTime: 2018/12/8  16:40
 * @Version: 1.0
 **/
public class GoodsParam extends Goods{

    private int page;
    private int rows;

    private String q;//做easyUI-combobox的实时智能提示时，接收的客户端查询参数


    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
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
