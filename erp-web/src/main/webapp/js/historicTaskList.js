$(function(){
	
	$('#grid').datagrid({
		url:'activiti_historicTaskList.action',
		columns:[[
		   {'field':'processDefinitionId','title':'流程定义ID','width':200 },      
		   {'field':'processInstanceId','title':'流程实例ID','width':200 },      
		   {'field':'taskDefinitionKey','title':'任务定义KEY','width':200 },      
		   {'field':'id','title':'任务ID','width':200 },      
		   {'field':'name','title':'任务名称','width':200 }  ,	
		   {'field':'assignee','title':'执行人','width':200 , formatter: function(value){
			   return emp[value];
		   }}  ,
		   {'field':'endTime','title':'任务完成时间','width':200,formatter:function(value){
			   return new Date(value).Format('yyyy-MM-dd hh:mm:ss');
		   } }  		          
		 ]],
		pagination:true
	});
	
	$('#btnSearch').bind('click',function(){
		var fordata=getFormData('searchForm');
		$('#grid').datagrid('load',fordata);		
	});
	
});