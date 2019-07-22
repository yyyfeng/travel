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
<title>主题列表</title>
</head>
<body>
	<table id="table" class="easyui-datagrid" style="width:800px;height:400px"   
        data-options="url:'menu?op=list',singleSelect:true,toolbar:toolbar,pagination:true">   
    <thead>   
        <tr>   
            <th data-options="field:'menuId',width:100">主题编号</th>   
            <th data-options="field:'menuDesc',width:100">主题描述</th>   
        </tr>   
    </thead>   
	</table>
	<div id="win" class="easyui-window" title="添加主题" style="width:800px;height:600px"   
        data-options="closed:true,iconCls:'icon-save',modal:true">   
    	<iframe src="addMenu.jsp" width="100%" height="100%"></iframe>
	</div>
	<div id="edit" class="easyui-window" title="编辑主题" style="width:800px;height:600px"   
        data-options="closed:true,iconCls:'icon-save',modal:true">   
    	<iframe id="editMenu" src="editMenu.jsp" width="100%" height="100%"></iframe>
	</div>
	 <script type="text/javascript">
		var toolbar=[
			{ text:'编辑'	,iconCls: 'icon-edit',handler: function(){
				inputed();
			}},
		'-',{ text:'添加', iconCls: 'icon-add',handler: function(){
			$('#win').window('open');
			$('#table').datagrid('reload'); 
		}},
		'-',{ text:'删除',iconCls: 'icon-remove',handler: function(){
			remove();
			$('#table').datagrid('reload'); 
		}}
		];
	</script>
	<script type="text/javascript">
		function remove(){
			//获取所选行数据
			var row = $("#table").datagrid("getSelected");
			var id= row.menuId;
			$.ajax({
				type:"GET",
				url:"menu?op=remove",
				data:{menuId:id},
				dataType:"json",
				success:function(data){
					if(data=='1'){
						alert("删除成功");
					}else if(data=='0'){
						alert("删除失败");
					}else{
						alert("获取失败");
					}
				}
			})
		}
		function inputed(){
			//获取所选行数据
			var row = $("#table").datagrid("getSelected");
			var id= row.menuId;
			$.ajax({
				type:"GET",
				url:"menu?op=inputed",
				data:{menuId:id},
				dataType:"json",
				success:function(data){
					$('#edit').window('open');
					//在ID为的元素中查找id为name的元素，并为id为name的元素设置value值为node节点的name
					//contents() 方法获得匹配元素集合中每个元素的子节点，包括文本和注释节点。
					$('#editMenu').contents().find('#menuId').val(data.menuId);
					$('#editMenu').contents().find('#menuDesc').val(data.menuDesc);
					$('#editMenu').contents().find('#span').html("<img  src='"+data.menuImg+"' width='50' height='50'/>");
					$('#editMenu').contents().find('#menuImg').val(data.menuImg);
				}
			})
		}
		
		window.closeWin=function(){
			//关闭当前页面
			$('#win').window('close');
			$('#edit').window('close');
			window.location.reload();
		}
	</script>
	
</body>
</html>