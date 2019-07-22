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
		data-options="url:'appoint?op=list',singleSelect:true,rownumbers:true,
				pagination:true,toolbar:toolbar">
		<thead>
			<tr>
				<th data-options="field:'appointId'">预约单号</th>
				<th data-options="field:'appointName'">预约姓名</th>
				<th data-options="field:'appointTel'">预约电话</th>
				<th data-options="field:'appointDest'">目的地</th>
				<th data-options="field:'appointDay'">行程天数</th>
				<th data-options="field:'appointTime'">出发时间</th>
				<th data-options="field:'appointAdult'">成人数</th>
				<th data-options="field:'appointChild'">儿童数</th>
				<th data-options="field:'userId'">用户编号</th>
				<th data-options="field:'appointStatus', formatter:statusFormatter">状态</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
	function statusFormatter(value){
		return value==1?'已处理':'未处理';
	}
	function remove(){
		//首先获取要删除的当前行数据
		var row=$("#table").datagrid("getSelected");;
		var id=row.appointId;
		console.log(id);
		if (row.appointStatus=='1') {
			alert("该预约单已经处理完成！！！");
		}else{
		$.ajax({
			type:"GET",
			url:"appoint?op=updateStatus",
			data:{appointId:id},
			success:function(result){
				if (result=='1') {
					alert("处理成功！");
					//刷新页面
					$("#table").datagrid("reload");
				}
			}
		});
		}
	}
	//恢复用户的权限，即解除被禁用的状态
	function unRemove(){
		//首先获取要删除的当前行数据
		var row=$("#table").datagrid("getSelected");;
		var id=row.appointId;
		console.log(id);
		if (row.appointStatus=='0') {
			alert("该预约单尚未处理！！！");
		}else{
		$.ajax({
			type:"GET",
			url:"appoint?op=reUpdateStatus",
			data:{appointId:id},
			success:function(result){
				if (result=='1') {
					alert("修改成功！");
					//刷新页面
					$("#table").datagrid("reload");
				}
			}
		});
		}
	}
	function closeWin(){
		$('#edit').window('close');
		$('#add').window('close');
		//$("#table").datagrid("reload");
		window.location.reload();
	} 
		var toolbar = [ {
			text : '处理完成',
			iconCls : 'icon-remove',
			handler : function() {
				remove();
			}
		}, '-', {
			text : '尚未处理',
			iconCls : 'icon-add',
			handler : function() {
				unRemove();
			}
		} ];
	</script>
</body>