//获取全局项目名
var app_path = localStorage.getItem("app_path");
var isEditingRowIndex;//当前编辑行
$(function(){
	
	$('#grid').datagrid({
		columns:[[    
		            {field:'goodsuuid',title:'商品ID',width:100},
	          		{field:'goodsname',title:'商品名称',width:100,
		            	editor:{
		            		type:'combobox',
		            		options:{
		            			url:app_path+'/goods/getAllForCombobox',
		            			valueField:'name',
		            			textField:'name',
		            			onSelect:function(record)
		            			{	
		            				console.log(">>>>>>>>>>>>>>>>>>>record::");
		            				console.log(record);
		            				//设置单价***********************
		            				//单价编辑框
		            				var priceEdt= $('#grid').datagrid('getEditor',{index:isEditingRowIndex,field:'price'});
		            				//设置进货价
		            				
		            				if(Request['type']=='1')
	            					{
		            					$(priceEdt.target).val(record.inprice);//设置采购价格
	            					}
		            				if(Request['type']=='2')
	            					{
		            					$(priceEdt.target).val(record.outprice);//设置销售价格
	            					}

		            				//*****************************
		            				//设置商品ID
		            				$('#grid').datagrid('getRows')[isEditingRowIndex].goodsuuid=record.uuid;
		            				
		            				
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
				iconCls: 'icon-add',
				text:'添加商品项',
				handler: function(){
					//关闭上一次处于编辑状态的行
					$('#grid').datagrid('endEdit',isEditingRowIndex);

					//动态添加一行
					$('#grid').datagrid('appendRow',{});
					
					//返回当前新增行的行号
					isEditingRowIndex= $('#grid').datagrid('getRows').length-1;

					//让每一个新增行，新增后自动变为编辑状态
					$('#grid').datagrid('beginEdit',isEditingRowIndex);
					
					bindGridEvent();
				}
			}],
			onClickRow:function(rowIndex, rowData)  //手动点击某行，使之成为可编辑状态；
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
	

	//************************* 初始化-加载供应商下拉列表
	
	$('#supplier').combogrid(  {
		idField:'uuid',
		textField:'name',
		width:400,
		panelWidth:700,
		url:app_path+'/supplier/getlistByPage'+'?type='+Request['type'],
		columns:[[    
		            {field:'uuid',title:'ID',width:100},
	          		{field:'name',title:'名称',width:100},
	          		{field:'address',title:'地址',width:100},
	          		{field:'contact',title:'联系人',width:100},
	          		{field:'tele',title:'电话',width:100},
	          		{field:'type',title:'类型',width:100,formatter: function (value) {
                        if (value == 1) {
                            return "供应商";
                        }
                        else {
                            return "客户";
                        }}
	          		}   
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
	//保存金额到当前行对象中
	$('#grid').datagrid("getRows")[isEditingRowIndex].money=num*price;
	$('#grid').datagrid("getRows")[isEditingRowIndex].num=num;

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
	
	//价格编辑框
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
	var totalMoney=0;//总金额
	var totalNum=0;//总数量
	for(var i=0;i<rows.length;i++)
	{
        totalMoney+=parseInt( rows[i].money);
        totalNum+=parseInt( rows[i].num);
	}
	$('#totalMoney').html(totalMoney);
	$('#totalNum').html(totalNum);
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
	
	
	formdata['orderdetailsJsonString']=JSON.stringify( $('#grid').datagrid('getRows'));
	
	
	
	$.ajax({
		url:app_path+'orders/addOne'+'?ordertype='+Request['type'],
		data:formdata,
		type:'post',
		success:function(data)
		{
			if(data.success)
			{
				//将表格置空
				$('#grid').datagrid('loadData',{total:0,rows:[]});
				$('#sum').html("0");
                $.messager.alert("提示","提交成功！");
			}else
			{
				$.messager.alert("提示",data.errorMessage);
			}
		}
		
	});

}
