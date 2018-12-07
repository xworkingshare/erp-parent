var method="add";//执行的方法名  add 或update

$(function(){
	
	if(typeof(listParam)=="undefined"){
		listParam="";
	}
	if(typeof(saveParam)=="undefined"){
		saveParam="";
	}
	
	$('#grid').datagrid({
		url:name+'_listByPage.action'+listParam,
		columns:columns,
		pagination:true,
		toolbar: [{
			iconCls: 'icon-edit',
			text:'添加',
			handler: function(){
				method="add";//方法为添加 
				$('#editWindow').window('open');
				$('#editForm').form('clear');//设置空数据
			}
		}]

	});	
	
	
	$('#btnSearch').bind('click',function()
	{
		//得到表单的封装值
		var formdata= getFormData('searchForm');
		//测试
		//alert( JSON.stringify( formdata));
		//调用datagrid的加载数据的方法
		$('#grid').datagrid('load',formdata);
	});
	
	$('#btnSave').bind('click',function()
	{	
		//判断表单中的所有字段是否通过验证
		var isvalidate=$('#editForm').form('validate');
		//如果未通过验证  拦截请求
		if(isvalidate==false)
		{
			return;
		}
		
		//得到表单的封装值
		var formdata= getFormData('editForm');
		$.ajax({
			url:name+'_'+ method +'.action'+saveParam,
			data:formdata,
			type:'post',
			success:function(value)
			{
				if(value=='ok'){
					$.messager.alert("提示","保存成功");
					//回调之后关闭窗口
					$('#editWindow').window('close');
					
					$('#grid').datagrid('reload');	//刷新表格数据 
				}else
				{
					$.messager.alert("提示",value);
				}				
				
			}
		});		
	});
});

/**
 * 删除数据
 */
function dele(id)
{
	$.messager.confirm("提示信息","确定要删除吗？", function(value){
		
		if(value)
		{
			$.ajax({
				url:name+'_delete.action?id='+id,			
				success:function(value)
				{
					if(value=='ok'){
						//删除成功后自动刷新表格
						$('#grid').datagrid('reload');				
					}else
					{
						$.messager.alert("提示",value);
					}
				}
			});		
		}		
	});
}

/**
 * 修改读取数据 方法
 */
function edit(id)
{
	method="update";
	//弹出窗口 
	$('#editWindow').window('open');
	//表单加载数据 
	$('#editForm').form('load',name+'_get.action?id='+id);
}
