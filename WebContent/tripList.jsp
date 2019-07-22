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
<title>行程列表</title>
</head>
<body>
	<table id="table" class="easyui-datagrid" style="width:100%;height:500px"   
        data-options="url:'trip?op=list',singleSelect:true,toolbar:toolbar,pagination:true">   
		<thead>
			<tr>
				<th data-options="field:'tripId'">行程编号</th>
				<th data-options="field:'tripName'">行程名称</th>
				<th data-options="field:'tripDays'">行程天数</th>
				<th data-options="field:'tripDesc'">行程概述</th>
				<th data-options="field:'tripImg'">展示图片地址</th>
				<th data-options="field:'tripDest'">目的地</th>
				<th data-options="field:'experience'">专属体验</th>
				<th data-options="field:'tripDetail'">行程详情</th>
				<th data-options="field:'tripHotel'">推荐酒店</th>
				<th data-options="field:'tripCost'">行程费用</th>
				<th data-options="field:'costInclude'">费用包含</th>
				<th data-options="field:'costUnInclude'">费用不含</th>
				<th data-options="field:'reserveNote'">预定须知</th>
				<th data-options="field:'tripMenu'">主题编号</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		var toolbar=[
			{ text:'编辑'	,iconCls: 'icon-edit',handler: function(){
			inputed();
			$('#table').datagrid('reload');
		}},
		'-',{ text:'添加', iconCls: 'icon-add',handler: function(){
			//弹出添加窗体
			$('#tripAdd_win').window('open'); 
		}},
		'-',{ text:'删除',iconCls: 'icon-remove',handler: function(){
			remove();
			$('#table').datagrid('reload'); 
		}}
		];
	</script>
	<script type="text/javascript">
		function remove() {
			//获取所选行数据
			var row = $("#table").datagrid("getSelected");
			var id = row.tripId;
			console.log(id);
			$.ajax({
				type : "GET",
				url : "trip?op=remove",
				data : {tripId : id},
				dataType:"json",
				success : function(data) {
					console.log(data);
					if (data == '1') {
						alert("删除成功");
					} else if (data == '0') {
						alert("删除失败");
					} else {
						alert("获取失败");
					}
				}
			})
		}
		
		function inputed(){
			//获取所选行数据
			var row = $("#table").datagrid("getSelected");
			var id = row.tripId;
			console.log(id);
			$.ajax({
				type : "GET",
				url : "trip?op=inputed",
				data : {tripId : id},
				dataType : "json",
				success:function(data){
					
					$('#tripEdit_win').window('open');
					console.log(data);
					//在ID为的元素中查找id为name的元素，并为id为name的元素设置value值为node节点的name
					//contents() 方法获得匹配元素集合中每个元素的子节点，包括文本和注释节点。
					$('#editTrip').contents().find('#tripId').val(data.tripId);
					$('#editTrip').contents().find('#tripName').val(data.tripName);
					$('#editTrip').contents().find('#tripDesc').val(data.tripDesc);
					$('#editTrip').contents().find('#tripDest').val(data.tripDest);
					$('#editTrip').contents().find('#tripDays').val(data.tripDays);
					//$('#editTrip').contents().find('#experience').val(data.experience);
					$("#editTrip")[0].contentWindow.setmessage('experience',data.experience);
					//$('#editTrip').contents().find('#tripHotel').val(data.tripHotel);
					$("#editTrip")[0].contentWindow.setmessage('tripHotel',data.tripHotel);
					$('#editTrip').contents().find('#tripCost').val(data.tripCost);
					$("#editTrip")[0].contentWindow.setmessage('costInclude',data.costInclude);
					//$('#editTrip').contents().find('#costUnInclude').val(data.costUnInclude);
					$("#editTrip")[0].contentWindow.setmessage('costUnInclude',data.costUnInclude);
					//$('#editTrip').contents().find('#reserveNote').val(data.reserveNote);
					$("#editTrip")[0].contentWindow.setmessage('reserveNote',data.reserveNote);
					$('#editTrip').contents().find('#tripMenu').val(data.tripMenu);
					$('#editTrip').contents().find('#tripImg').val(data.tripImg);
					$('#editTrip').contents().find('#span').html("<img  src='"+data.tripImg+"' width='50' height='50'/>");
					$("#editTrip")[0].contentWindow.setmessage('tripDetail',data.tripDetail);
				}
			})
		}
		
		function closeWin(){
			$('#tripAdd_win').window('close');
			$('#tripEdit_win').window('close');
			window.location.reload();
		}
	</script>
	<div id="tripAdd_win" class="easyui-window" title="添加行程" style="width:800px;height:600px"   
        data-options="closed:true,iconCls:'icon-save',modal:true,url:'addTrip.jsp'">   
    	<iframe src="addTrip.jsp" width="100%" height="100%"></iframe>
	</div>
	<div id="tripEdit_win" class="easyui-window" title="编辑行程" style="width:800px;height:600px"   
        data-options="closed:true,iconCls:'icon-save',modal:true,url:'editTrip.jsp'">   
    	<iframe id="editTrip" src="editTrip.jsp" width="100%" height="100%"></iframe>
	</div>
</body>