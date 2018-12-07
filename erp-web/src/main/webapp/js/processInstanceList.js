function showProcessWindow(processDefinitionId,activityId)
{
	$('#processWindow').window('open');
	$('#processImg').attr('src','activiti_writePngToOs.action?processDefinitionId='+processDefinitionId+'&activityId='+activityId);
}