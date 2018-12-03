var isEditingRowIndex;//当前编辑行
$(function(){
	
	$('#grid').datagrid({
		columns:[[    
		            {field:'goodsUuid',title:'商品ID',width:100},
	          		{field:'goodsName',title:'商品名称',width:100,
		            	editor:{
		            		type:'combobox',
		            		options:{
		            			url:'goods_list.action',
		            			valueField:'name',
		            			textField:'name',
		            			onSelect:function(record)
		            			{	
		            				//设置单价***********************
		            				//单价编辑框
		            				var priceEdt= $('#grid').datagrid('getEditor',{index:isEditingRowIndex,field:'price'});
		            				//设置进货价
		            				
		            				if(Request['type']=='1')
	            					{
		            					$(priceEdt.target).val(record.inPrice);//设置采购价格
	            					}
		            				if(Request['type']=='2')
	            					{
		            					$(priceEdt.target).val(record.outPrice);//设置销售价格
	            					}
		            				
		            				//*****************************
		            				//设置商品ID
		            				$('#grid').datagrid('getRows')[isEditingRowIndex].goodsUuid=record.uuid;
		            				
		            				
		            				//关闭行编辑后再开启
		            				$('#grid').datagrid('endEdit',isEditingRowIndex);
		            				$('#grid').datagrid('beginEdit',isEditingRowIndex);
		            				
		            				bindGridEvent();
		            				cal();//计算
		            			}
		            		}
		            }},
	          		{field:'price',title:'价格',width:100,editor:'numberbox'},
	          		{field:'num',title:'数量',width:100,editor:'numberbox'},	          		
	          		{field:'money',title:'金额',width:100,editor:'numberbox'} ,
	          		{field:'-',title:'操作',width:100,formatter:function(value,row,index){
	          			return "<a href='#' onclick='deleteRow("+ index +")'>删除</a>";
	          		}}
	          		       		
	       ]],
	      toolbar: [{
				iconCls: 'icon-edit',
				text:'添加',
				handler: function(){
					//关闭上一次处于编辑状态的行
					$('#grid').datagrid('endEdit',isEditingRowIndex);
					
					$('#grid').datagrid('appendRow',{});
					
					//让每一行新增后都变为编辑状态
					//得到行数
					isEditingRowIndex= $('#grid').datagrid('getRows').length-1;
										
					$('#grid').datagrid('beginEdit',isEditingRowIndex);
					
					bindGridEvent();
				}
			}],
			onClickRow:function(rowIndex, rowData)
			{
				//关闭上一次处于编辑状态的行
				$('#grid').datagrid('endEdit',isEditingRowIndex);
				isEditingRowIndex=rowIndex;
				//开启本次点击行为编辑状态
				$('#grid').datagrid('beginEdit',isEditingRowIndex);
				bindGridEvent();
			},
			singleSelect:true
		
	});
	
	///////////////////////////////////////////////////////////
	//供应商下拉列表
	
	$('#supplier').combogrid(  {
		idField:'uuid',
		textField:'name',
		width:400,
		panelWidth:700,
		url:'supplier_list.action?t1.type='+Request['type'],
		columns:[[    
		            {field:'uuid',title:'ID',width:100},
	          		{field:'name',title:'名称',width:100},
	          		{field:'address',title:'地址',width:100},
	          		{field:'contact',title:'联系人',width:100},
	          		{field:'tele',title:'电话',width:100},
	          		{field:'type',title:'类型',width:100}   
	            ]]
	});
	
	
	
});
/**
 * 计算
 * @returns
 */
function cal()
{
	//数量编辑框
	var numEdt= $('#grid').datagrid('getEditor',{index:isEditingRowIndex,field:'num'});	
	//单价编辑框
	var priceEdt= $('#grid').datagrid('getEditor',{index:isEditingRowIndex,field:'price'});
	//金额编辑框
	var moneyEdt= $('#grid').datagrid('getEditor',{index:isEditingRowIndex,field:'money'});
	var num= $(numEdt.target).val();//得到数量
	var price= $(priceEdt.target).val();//得到单价
	
	$(moneyEdt.target).val(num*price);//设置金额
	$('#grid').datagrid("getRows")[isEditingRowIndex].money=num*price;
	
}

/**
 * 绑定表格编辑框
 * @returns
 */
function bindGridEvent()
{
	//数量编辑框
	var numEdt= $('#grid').datagrid('getEditor',{index:isEditingRowIndex,field:'num'});	
	$(numEdt.target).bind('keyup',function()
	{	
		cal();//调用计算
		sum();//求和
	});
	
	//数量编辑框
	var priceEdt= $('#grid').datagrid('getEditor',{index:isEditingRowIndex,field:'price'});	
	$(priceEdt.target).bind('keyup',function()
	{
		cal();//调用计算
		sum();//求和
	});	
}

/**
 * 移除一行
 * @param index
 * @returns
 */
function deleteRow(index)
{
	$('#grid').datagrid('deleteRow',index);
}

function sum()
{
	var rows= $('#grid').datagrid('getRows');
	var money=0;//金额
	for(var i=0;i<rows.length;i++)
	{		
		money+=parseInt( rows[i].money);
	}
	$('#sum').html(money);
}

/**
 * 添加订单
 * @returns
 */
function addOrder()
{
	
	//关闭上一次处于编辑状态的行
	$('#grid').datagrid('endEdit',isEditingRowIndex);
	
	//得到表单值（供应商）
	var formdata=getFormData("orderForm");
	
	
	formdata['json']=JSON.stringify( $('#grid').datagrid('getRows'));
	
	
	
	$.ajax({
		url:'orders_add.action?t.orderType='+Request['type'],
		data:formdata,
		type:'post',
		success:function(value)
		{
			if(value=='ok')
			{
				//将表格置空
				$('#grid').datagrid('loadData',{total:0,rows:[]});
			}else
			{
				$.messager.alert("提示",value);
			}
		}
		
	});

}
