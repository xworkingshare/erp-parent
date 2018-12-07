$(function(){
			
});
var roleId;//角色ID

var clickRow=function(rowIndex, rowData){
	
	
	roleId=rowData.uuid;//全局变量赋值
	
	$('#tree').tree({
		url:'role_readRoleMenus.action?id='+rowData.uuid,
		animate:true,
		checkbox:true
	});	
	
}

function save()
{
	var nodes = $('#tree').tree('getChecked');
	var ids="";
	for(var i=0;i<nodes.length;i++)
	{
		if(i!=0){
			ids+=",";
		}		
		ids+=nodes[i].id;		
	}
	
	var data={'id':roleId,menuIds:ids};
	$.ajax({
		url:'role_updateRoleMenus.action',
		type:'post',
		data:data,
		success:function(value)
		{
			if(value=='ok')
			{	
				$.messager.alert("提示","保存权限成功");
			}else
			{
				$.messager.alert("提示",value);
			}
		}
		
	});
	
	
}