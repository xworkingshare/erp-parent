var g_index;//主表索引
var g_index2;//从表索引

$(function(){
	
	$('#grid').datagrid({
		url:url,
		columns:[[    
	          		{field:'uuid',title:'ID',width:30},
	          		{field:'orderNum',title:'订单编号',width:100},
	          		{field:'createTime',title:'生成日期',width:80,formatter:function(value){
	          			return new Date(value).Format('yyyy-MM-dd');
	          		}},
	          		{field:'checkTime',title:'检查日期',width:80,formatter:function(value){
	          			return new Date(value).Format('yyyy-MM-dd');
	          		}},
	          		{field:'startTime',title:'开始日期',width:80,formatter:function(value){
	          			return new Date(value).Format('yyyy-MM-dd');
	          		}},
	          		{field:'endTime',title:'结束日期',width:80,formatter:function(value){
	          			return new Date(value).Format('yyyy-MM-dd');
	          		}},
	          		{field:'orderType',title:'订单类型',width:80,formatter:function(value){
	          			return orderType[value];
	          		}},
	          		{field:'creater',title:'下单员',width:80,formatter:function(value){
	          			return emp[value];
	          		}},
	          		{field:'checker',title:'审查员',width:80,formatter:function(value){
	          			return emp[value];
	          		}},
	          		{field:'starter',title:'采购员',width:80,formatter:function(value){
	          			return emp[value];
	          		}},
	          		{field:'ender',title:'库管员',width:80,formatter:function(value){
	          			return emp[value];
	          		}},
	          		{field:'supplierUuid',title:'供应商ID',width:80},
	          		{field:'totalNum',title:'总数量',width:80},
	          		{field:'totalPrice',title:'总价格',width:80},
	          		{field:'state',title:'订单状态',width:80,formatter:function(value){
	          			return state[value];	          			
	          		}},
	          		operation
	         ]],
	         pagination:true,
	         singleSelect:true,
	         view:detailview,
	         detailFormatter:function(index,row)
	         {
	        	 return "<table id='ddv-" + index+ "'></table>";
	         },
	         onExpandRow:function(index,row)
	         {
	        	 $('#ddv-'+index).datagrid({
	        		 data:row.orderdetails,
	        		 columns:[[    
	        	          		{field:'uuid',title:'ID',width:100},
	        	          		{field:'num',title:'数量',width:100},
	        	          		{field:'price',title:'价格',width:100},
	        	          		{field:'money',title:'金额',width:100},
	        	          		{field:'goodsUuid',title:'商品ID',width:100},
	        	          		{field:'goodsName',title:'商品ID',width:100},
	        	          		{field:'orderUuid',title:'订单ID',width:100},
	        	          		{field:'endTime',title:'出入库时间',width:100},
	        	          		{field:'ender',title:'库管员',width:100},
	        	          		{field:'storeUuid',title:'仓库编号',width:100},
	        	          		{field:'state',title:'状态',width:100}	        	          		         		
	        	          		         		    ]],
	        	       onDblClickRow:function(rowIndex,rowData)
	        	       {
	        	    	   g_index=index;//主表
	        	    	   g_index2=rowIndex;//子表INDEX
	        	    	   $('#orderWindow').window('open');//打开窗口
	        	    	   $('#goodsUuid').html(rowData.goodsUuid);//商品编号
	        	    	   $('#goodsName').html(rowData.goodsName);//名称
	        	    	   $('#num').html(rowData.num);//数量
	        	    	   $('#uuid').val(rowData.uuid);//订单明细UUID
	        	    	   
	        	    	   //判断是显示出库按钮还是显示入库按钮
	        	    	   
	        	    	   if(Request['type']=='1')
        	    		   {
	        	    		   $('#outBtn').hide();
        	    		   }
	        	    	   if(Request['type']=='2')
        	    		   {
	        	    		   $('#inBtn').hide();
        	    		   }
	        	    	   
	        	       },
	        	       singleSelect:true,
	        	       loadFilter: function(data){
	        	    	   var value={total:0,rows:[]};
	        	    	   
	        	    	   for(var i=0;i<data.length;i++)
        	    		   {
	        	    		  var row= data[i];
	        	    		  if(row.state=='0')
        	    			  {
	        	    			  value.rows.push(row); 
        	    			  }	        	    		  
        	    		   }
	        	    	   value.total= value.rows.length;//设置数量
	        	    	   
	        	    	   return value;
	        	       }
	        		 
	        	 });
	        	 
	        	 $('#grid').datagrid('fixDetailRowHeight',index);
	         }
	         
	         
	         
	         
		
	});
	
	
	
});

/**
 * 订单审核
 * @param uuid
 * @returns
 */
function doCheck(uuid)
{
	$.messager.confirm('提示信息','确定要审核吗？',function(value){
		
		if(value)
		{
			$.ajax({
				url:'orders_doCheck.action?id='+uuid,
				success:function(value)
				{
					if(value=='ok')
					{
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
 * 订单确认
 * @param uuid
 * @returns
 */
function doStart(uuid)
{
	$.messager.confirm('提示信息','确定要确认吗？',function(value){
		
		if(value)
		{
			$.ajax({
				url:'orders_doStart.action?id='+uuid,
				success:function(value)
				{
					if(value=='ok')
					{
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
 * 订单入库
 * @returns
 */
function doInStore()
{
	
	var orderData=getFormData('orderForm');//得到窗口表单数据
	$.ajax({
		url:'orderdetail_doInStore.action',
		type:'post',
		data:orderData,
		success:function(value)
		{
			if(value=='ok')
			{
				$('#ddv-'+g_index).datagrid('deleteRow',g_index2);//移除从表行
				$('#orderWindow').window('close');//关闭
				var count=  $('#ddv-'+g_index).datagrid('getRows').length;
				if(count==0)
				{
					$('#grid').datagrid('deleteRow',g_index);//移除主表的行
				}
				
			}else
			{
				$.messager.alert("提示",value);
			}
		}
		
	});

	

}




/**
 * 订单出库
 * @returns
 */
function doOutStore()
{
	
	var orderData=getFormData('orderForm');//得到窗口表单数据
	$.ajax({
		url:'orderdetail_doOutStore.action',
		type:'post',
		data:orderData,
		success:function(value)
		{
			if(value=='ok')
			{
				$('#ddv-'+g_index).datagrid('deleteRow',g_index2);//移除从表行
				$('#orderWindow').window('close');//关闭
				var count=  $('#ddv-'+g_index).datagrid('getRows').length;
				if(count==0)
				{
					$('#grid').datagrid('deleteRow',g_index);//移除主表的行
				}
				
			}else
			{
				$.messager.alert("提示",value);
			}
		}
		
	});

	

}

