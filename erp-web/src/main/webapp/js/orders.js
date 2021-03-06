var app_path = localStorage.getItem("app_path");
var g_index;//主表索引			（订单表Orders表）
var g_index2;//从表索引		（订单明细表Orderdetail表）
var currentExpandRowIndex;  //  当前展开订单详情的订单，所在行索引号；

$(function () {

    $('#grid').datagrid({
        height: 500,
        url: url,
        columns: [[
            {
                field: 'state', title: '订单状态', width: 80, formatter: function (value) {
                return state[value];
            }
            },
            operation,
            {field: 'uuid', title: 'ID', width: 50},
            {field: 'ordernum', title: '订单编号', width: 200},
            {
                field: 'createtime', title: '生成日期', width: 200, formatter: function (value) {
                return new Date(value).Format('yyyy-MM-dd');
            }
            },
            {
                field: 'checktime', title: '检查日期', width: 200, formatter: function (value) {
                return new Date(value).Format('yyyy-MM-dd');
            }
            },
            {
                field: 'starttime', title: '开始日期', width: 200, formatter: function (value) {
                return new Date(value).Format('yyyy-MM-dd');
            }
            },
            {
                field: 'endtime', title: '结束日期', width: 200, formatter: function (value) {
                return new Date(value).Format('yyyy-MM-dd');
            }
            },
            {
                field: 'ordertype', title: '订单类型', width: 200, formatter: function (value) {
                return orderType[value];
            }
            },
            {field: 'creatername', title: '下单员', width: 150},
            {field: 'checkername', title: '审查员', width: 150},
            {field: 'startername', title: '采购员', width: 150},
            {field: 'endername', title: '库管员', width: 150},
            {field: 'suppliername', title: '供应商', width: 150},
            {field: 'totalnum', title: '总数量', width: 80},
            {field: 'totalprice', title: '总价格', width: 80}

        ]],
        pagination: true,
        singleSelect: true,
        view: detailview,
        detailFormatter: function (index, row) {
            return "<table id='ddv-" + index + "'></table>";
        },
        onExpandRow: function (index, row) {

            $('#ddv-' + index).datagrid({
                // data:row.orderdetails,
                style: {borderWidth: 4},
                url: app_path + "/orderdetail/getlistAll?orderuuid=" + row.uuid,
                columns: [[
                    {field: 'uuid', title: 'ID', width: 100},
                    {field: 'num', title: '数量', width: 100},
                    {field: 'price', title: '价格', width: 100},
                    {field: 'money', title: '金额', width: 100},
                    {field: 'goodsUuid', title: '商品ID', width: 100},
                    {field: 'goodsName', title: '商品名', width: 100},
                    {field: 'orderUuid', title: '订单ID', width: 100},
                    {field: 'endTime', title: '出入库时间', width: 100},
                    {field: 'ender', title: '库管员', width: 100},
                    {field: 'storeUuid', title: '仓库编号', width: 100},
                    {
                        field: 'state', title: '状态', width: 100, formatter: function (value) {
                        if (value == 0) {
                            if (row.ordertype == 1) {
                                return "未入库";
                            }else {
                                return "未出库";
                            }
                        }
                        else if (value == 1){
                            if (row.ordertype == 3) {
                                return "已入库";
                            }else {
                                return "已出库";
                            }
                        }
                    }
                    }
                ]],
                onDblClickRow: function (rowIndex, rowData) {
                    g_index = index;//主表
                    g_index2 = rowIndex;//子表INDEX
                    $('#orderWindow').window('open');//打开窗口，orderWindow窗口，在orders_2.html页面中才用得到
                    $('#goodsuuid').html(rowData.goodsuuid);//商品编号
                    $('#goodsname').html(rowData.goodsname);//名称
                    $('#num').html(rowData.num);//数量
                    $('#uuid').val(rowData.uuid);//订单明细UUID

                    //判断是显示出库按钮还是显示入库按钮

                    if (Request['type'] == '1') {
                        $('#outBtn').hide();
                    }
                    if (Request['type'] == '2') {
                        $('#inBtn').hide();
                    }

                },
                singleSelect: true,
                loadFilter: function (data) {
                    var value = {total: 0, rows: []};

                    for (var i = 0; i < data.length; i++) {
                        var row = data[i];
                        if (row.state == '0')//订单项只有2种状态：0未入出 库 和 1 已入出库
                        {
                            value.rows.push(row);
                        }
                    }
                    value.total = value.rows.length;//设置数量
                    return value;
                }

            });

            $('#grid').datagrid('fixDetailRowHeight', index);
            currentExpandRowIndex = index;

        }


    });

    /*查询条件表单中，点击查询按钮*/
    $('#btnSearch').bind('click', function () {
        //得到表单的封装值
        var formdata = getFormData('searchForm');
        //测试
        //alert( JSON.stringify( formdata));
        //调用datagrid的加载数据的方法
        $('#grid').datagrid('load', formdata);
    });

    /*查询条件表单中，给订单状态设置为combox*/
    $('#orderState').combobox({
        data: [{
            "id": "",
            "text": "全部",
            "selected": true
        },{
            "id": 0,
            "text": state[0]
        }, {
            "id": 1,
            "text": state[1]
        }, {
            "id": 2,
            "text": state[2]
        }, {
            "id": 3,
            "text": state[3]
        }],
        valueField: 'id',
        textField: 'text'
    });


});


/**
 * 订单审核
 * @param uuid
 * @returns
 */
function doCheck(uuid) {
    $.messager.confirm('提示信息', '确定要审核吗？', function (value) {

        if (value) {
            $.ajax({
                url: 'orders_doCheck.action?id=' + uuid,
                success: function (value) {
                    if (value == 'ok') {
                        $('#grid').datagrid('reload');
                    } else {
                        $.messager.alert("提示", value);
                    }
                }
            });

        }

    });


}


/**
 * 订单确认
 * @param uuid
 * @returns
 */
function doStart(uuid) {
    $.messager.confirm('提示信息', '确定要确认吗？', function (value) {

        if (value) {
            $.ajax({
                url: 'orders_doStart.action?id=' + uuid,
                success: function (value) {
                    if (value == 'ok') {
                        $('#grid').datagrid('reload');
                    } else {
                        $.messager.alert("提示", value);
                    }
                }
            });

        }

    });


}

/**
 * 订单入库
 * @returns
 */
function doInStore() {

    var orderData = getFormData('orderForm');//得到窗口表单数据
    $.ajax({
        url: 'orderdetail_doInStore.action',
        type: 'post',
        data: orderData,
        success: function (value) {
            if (value == 'ok') {
                $('#ddv-' + g_index).datagrid('deleteRow', g_index2);//移除从表行
                $('#orderWindow').window('close');//关闭
                var count = $('#ddv-' + g_index).datagrid('getRows').length;
                if (count == 0) {
                    $('#grid').datagrid('deleteRow', g_index);//移除主表的行
                }

            } else {
                $.messager.alert("提示", value);
            }
        }

    });


}


/**
 * 订单出库
 * @returns
 */
function doOutStore() {

    var orderData = getFormData('orderForm');//得到窗口表单数据
    $.ajax({
        url: 'orderdetail_doOutStore.action',
        type: 'post',
        data: orderData,
        success: function (value) {
            if (value == 'ok') {
                $('#ddv-' + g_index).datagrid('deleteRow', g_index2);//移除从表行
                $('#orderWindow').window('close');//关闭
                var count = $('#ddv-' + g_index).datagrid('getRows').length;
                if (count == 0) {
                    $('#grid').datagrid('deleteRow', g_index);//移除主表的行
                }

            } else {
                $.messager.alert("提示", value);
            }
        }

    });


}

