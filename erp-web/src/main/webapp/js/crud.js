var method = "add";//执行的方法名  add 或update

$(function () {

    if (typeof(listParam) == "undefined") {
        listParam = "";
    }
    if (typeof(saveParam) == "undefined") {
        saveParam = "";
    }

    //获取全局项目名
    var app_path = localStorage.getItem("app_path");

    //列表初始化查询
    $('#grid').datagrid({
        url: app_path + '/' + name + '/' + 'getlistByPage' + listParam,
        columns: columns,
        pagination: true,
        toolbar: [{
            iconCls: 'icon-add',
            text: '添加',
            handler: function () {
                method = "add";//方法为添加
                //修改窗口标题
                $('#editWindow').window({"title":"添加"});
                $('#editWindow').window('open');
                $('#editForm').form('clear');//设置空数据
            }
        }]

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


    /*添加数据/编辑数据窗口中，点击保存*/
    $('#btnSave').bind('click', function () {
        //判断表单中的所有字段是否通过验证
        var isvalidate = $('#editForm').form('validate');
        //如果未通过验证  拦截请求
        if (isvalidate == false) {
            return;
        }

        //得到表单的封装值
        var formdata = getFormData('editForm');
        //执行数据新增/数据修改操作，如下：
        $.ajax({
            url: app_path + '/' + name + '/' + method + 'One' + saveParam,
            data: formdata,
            type: 'post',
            success: function (data) {
                console.log(data);
                if (data.success) {

                    $.messager.alert("提示", "保存成功");
                    //关闭窗口
                    $('#editWindow').window('close');
                    //刷新表格数据
                    $('#grid').datagrid('reload');
                } else {

                    $.messager.alert("提示", data.errorMessage);
                }

            }
        });
    });
});


/**
 * 删除数据
 */
function dele(id) {
    //获取全局项目名
    var app_path = localStorage.getItem("app_path");
    method = "delete";
    $.messager.confirm("提示信息", "确定要删除吗？", function (value) {

        if (value) {
            $.ajax({
                url: app_path + '/' + name + '/' + method + 'One' ,
                type: 'post',
                data:{"uuid":id},
                success: function (data) {
                    console.log(data);
                    if (data.success) {

                        $.messager.alert("提示", "删除成功");
                        //刷新表格数据
                        $('#grid').datagrid('reload');
                    } else {

                        $.messager.alert("提示", data.errorMessage);
                    }
                }
            });
        }
    });
}

/**
 * 修改读取数据 方法
 */
function edit(id) {
    method = "update";

    //修改窗口标题
    $('#editWindow').window({"title":"修改"});
    //弹出窗口
    $('#editWindow').window('open');

    //获取全局项目名
    var app_path = localStorage.getItem("app_path");
    //表单加载数据
    $('#editForm').form('load', app_path + '/' + name + '/' + 'getOneById?id=' + id);
}
