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
		data-options="url:'user?op=userList',singleSelect:true,rownumbers:true,
				pagination:true,toolbar:toolbar">
		<thead>
			<tr>
				<th data-options="field:'userId'">用户编号</th>
				<th data-options="field:'nickName'">昵称</th>
				<th data-options="field:'userName'">姓名</th>
				<th data-options="field:'userTel'">电话</th>
				<th data-options="field:'userAge'">年龄</th>
				<th data-options="field:'userBirth'">生日</th>
				<th data-options="field:'userEmail'">邮箱</th>
				<th data-options="field:'userStatus', formatter:statusFormatter">状态</th>
			</tr>
		</thead>
	</table>
	<div id="add" class="easyui-window" title="添加用户"
		style="overflow: hidden; width: 500px; height: 500px ;margin-left: auto;margin-top: auto;"
		data-options="closed:true,iconCls:'icon-save',modal:true">
		<iframe src="addUser.jsp" width="100%" style="border: 0px;"
			height="100%"></iframe>
	</div>
	<div id="edit" class="easyui-window" title="修改用户"
		style="overflow: hidden; width: 500px; height: 500px; margin-left: auto; margin-top: auto;"
		data-options="closed:true,iconCls:'icon-save',modal:true">
		<iframe id="editUser" src="editUser.jsp" width="100%" style="border: 0px;"
			height="100%"></iframe>
	</div>
	<script type="text/javascript">
	function statusFormatter(value){
		return value==1?'正常':'禁用';
	}
	function remove(){
		//首先获取要删除的当前行数据
		var row=$("#table").datagrid("getSelected");;
		var id=row.userId;
		console.log(id);
		if (row.userStatus=='0') {
			alert("该用户已经被禁用，不需要删除！");
		}else{
		$.ajax({
			type:"GET",
			url:"user?op=remove",
			data:{userId:id},
			success:function(result){
				if (result=='1') {
					alert("删除成功！");
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
		var id=row.userId;
		console.log(id);
		if (row.userStatus=='1') {
			alert("该用户具有所有权限，不需要解除禁用！");
		}else{
		$.ajax({
			type:"GET",
			url:"user?op=unRemove",
			data:{userId:id},
			success:function(result){
				if (result=='1') {
					alert("恢复成功！");
					//刷新页面
					$("#table").datagrid("reload");
				}
			}
		});
		}
	}
	//数据修改之前，首先将数据进行回显
	function edit(){
		//首先获取要进行修改的数据行
		var row=$("#table").datagrid("getSelected");
		//然后获取id,此处是为了将id带着再进入跳转之后的界面
		var userId=row.userId;
		console.log(userId);
		$.ajax({
			type:"GET",
			url:"user?op=reviewUser",
			data:{userId:userId},
			dataType:'json',
			success:function(u){
				console.log(u);
				//进入跳转界面
				//则说明查询成功，直接获取到原本需要跳转的界面，获取页面所有的元素，包括布局和元素和节点
					$("#edit").window('open');
				//$('#editMenu').contents().find('#menuId').val(data.menuId);
					$("#editUser").contents().find('#userId').val(u.userId);
					$("#editUser").contents().find('#nickName').val(u.nickName);
					$("#editUser").contents().find('#userName').val(u.userName);
					$("#editUser").contents().find('#userTel').val(u.userTel);
					$("#editUser").contents().find('#userAge').val(u.userAge);
					$("#editUser").contents().find('#userBirth').val(u.userBirth);
					$("#editUser").contents().find('#userEmail').val(u.userEmail);
				
			}
			
		});
	}
	function closeWin(){
		$('#edit').window('close');
		$('#add').window('close');
		//$("#table").datagrid("reload");
		window.location.reload();
	} 
		var toolbar = [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				$("#add").window('open');
			}
		}, {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				edit();
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				remove();
			}
		}, '-', {
			text : '恢复权限',
			iconCls : 'icon-undo',
			handler : function() {
				unRemove();
			}
		} ];
	</script>
</body>