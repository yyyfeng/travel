<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="easyui/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="easyui/themes/icon.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

<table id="table" class="easyui-datagrid"
	style="width: 80%; margin-left: auto; margin-right: auto;"
	data-options="url:'order?op=list',singleSelect:true,pagination:true,toolbar:toolbar">
	<thead>
		<tr>
			<th data-options="field:'orderId'">订单编号</th>
			<th data-options="field:'createTime'">下单时间</th>
			<th data-options="field:'startTime'">出发时间</th>
			<th data-options="field:'adultNum'">成人人数</th>
			<th data-options="field:'childNum'">儿童人数</th>
			<th data-options="field:'userId'">用户编号</th>
			<th data-options="field:'tripId'">行程编号</th>
			<th data-options="field:'orderCost'">订单金额</th>
			<th data-options="field:'orderStatus',formatter:orderStatusFormatter">状态</th>
		</tr>
	</thead>
</table>
<div id="add" class="easyui-window" title="添加订单" style="width:600px;height:400px"   
        data-options="closed:true,iconCls:'icon-save',modal:true">   
    	<iframe src="addOrder.jsp" width="100%" height="100%"></iframe>
</div>
<div id="edit" class="easyui-window" title="修改订单" style="width:600px;height:400px"   
        data-options="closed:true,iconCls:'icon-save',modal:true">   
    	<iframe id="editOrder" src="editOrder.jsp" width="100%" height="100%"></iframe>
</div>
<script type="text/javascript">
function closeWin(){
	$('#add').window('close');
	$('#edit').window('close');
	window.location.reload();
} 
var toolbar=[
	{text:'添加',iconCls:'icon-add',handler:function(){
		$('#add').window('open');
	}},
	'-',
	{text:'编辑',iconCls:'icon-edit',handler:function(){edit();
	}},
	'-',
	{text:'删除',iconCls:'icon-remove',handler:function(){remove();
		$("#table").datagrid("reload");
	}},
	'-',
	{text:'未完成',iconCls:'icon-undo',handler:function(){status(0);
		$("#table").datagrid("reload");
	}},
	'-',
	{text:'已完成',iconCls:'icon-redo',handler:function(){status(1);
		$("#table").datagrid("reload");
	}},
	'-',
];

function orderStatusFormatter(value){
	return value==1?"已完成":"未完成";
}
//删除事件
function remove(){
	//获取当前选中行数据
	var row = $("#table").datagrid("getSelected");
	var orderId = row.orderId;
	//删除前确认弹框
	if(confirm("确认删除吗")){
		//删除事件
		$.ajax({
			type:"GET",
			url:"order?op=delete",
			data:{orderId:orderId},
			dataType:"json",
			success:function(result){
				//console.log(result);
				if(result="1"){
					alert("删除成功");
				}else{
					alert("删除失败");
				}
			}
		});
	}
}
//修改状态事件
function status(temp){
	//获取数据
	var row = $("#table").datagrid("getSelected");
	var orderStatus = temp;
	var orderId = row.orderId;
	$.ajax({
		type:"GET",
		url:"order?op=status",
		data:{orderId:orderId,orderStatus:orderStatus},
		dataType:"json",
		success:function(result){
			console.log(result);
			if(result="1"){
				alert("修改成功");
			}else{
				alert("修改失败");
			}
		}
	});
}
//编辑回显事件
function edit(){
	var row = $("#table").datagrid("getSelected");
	var orderId = row.orderId;
	console.log(orderId);
	$.ajax({
		type:"GET",
		url:"order?op=reviewOrder",
		data:{orderId:orderId},
		dataType:"json",
		success:function(o){
			console.log(o);
			console.log(o.orderId);
			console.log(o.orderStatus);
			console.log(o.startTime);
			//进行到这里说明查到数据，则跳转页面，打开#edit
			$("#edit").window('open');
			//填充数据
			$("#editOrder").contents().find('#orderId').val(o.orderId);
			$("#editOrder").contents().find('#orderStatus').val(o.orderStatus);
			$("#editOrder").contents().find('#startTime').val(o.startTime);
			$("#editOrder").contents().find('#createTime').val(o.createTime);
			$("#editOrder").contents().find('#adultNum').val(o.adultNum);
			$("#editOrder").contents().find('#childNum').val(o.childNum);
			$("#editOrder").contents().find('#userId').val(o.userId);
			$("#editOrder").contents().find('#tripId').val(o.tripId);
			$("#editOrder").contents().find('#orderCost').val(o.orderCost);
		}
	});
}
</script>

</body>
