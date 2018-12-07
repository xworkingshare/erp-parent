$(function(){
	
	$('#grid').datagrid({
		url:'sheet_orderSheet.action',
		columns:[[
		   {field:'name',title:'商品分类',width:200} ,      
		   {field:'money',title:'金额',width:200}       
		   ]]
	
	});
	
	
});
/*
 * 执行统计
 */
function doSum()
{
	//得到表单的数据 
	var data=getFormData('sheetForm');
	$('#grid').datagrid('load',data);	
	//输出统计图
	$('#chart').attr('src','sheet_orderChart.action?date1='+ data['date1']+'&date2='+data['date2']);
	
}

function excel()
{
	//得到表单的数据 
	var data=getFormData('sheetForm');
	window.open("sheet_orderExcel.action?date1="+  data['date1'] +"&date2="+data['date2']);
	
}