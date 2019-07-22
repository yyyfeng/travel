<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加订单</title>
<link href="easyui/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="easyui/themes/icon.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.all.min.js"></script>
<style>
.input{
	width: 300px;
	height: 25px;
}
.field{
	margin: 5px;
}
</style>
</head>
<body>
	<div style="width:600px;padding:30px 60px;  margin-left: auto; margin-right: auto;">
	<form  action="order?op=edit" id="ff" method="post">
		<input type="hidden" name="orderId" id="orderId" value=""/>
		<input type="hidden" name="orderStatus" id="orderStatus" value=""/>
		<input type="hidden" name="createTime" id="createTime" value=""/>
		<div class='field'>
			<label for="startTime">出发时间:</label> <input class="input"
				type="text" name="startTime" id="startTime" />
		</div>
		<div class='field'>
			<label for="adultNum">成人数:</label> <input
				class="input" type="text" name="adultNum" id="adultNum" />
		</div>
		<div class='field'>
			<label for="childNum">儿童数:</label> <input
				class="input" type="text" name="childNum" id="childNum"
				 />
		</div>
		<div class='field'>
			<label for="userId">用户编号:</label> <input class="input"
				type="text" name="userId" id="userId" />
		</div>
		<div class='field'>
			<label for="tripId">行程编号:</label> <input class="input"
				type="text" name="tripId" id="tripId"  />
		</div>
		<div class='field'>
			<label for="orderCost">订单金额:</label> <input class="input"
				type="text" name="orderCost" id="orderCost"  />
		</div>
		<div class='field'>
			<input type="button" onclick="sub()" value="提交"/>
		</div>
	</form>
	</div>
	<script type="text/javascript">
	function sub(){
		//提交表单
		document.getElementById("ff").submit();
		//关闭窗口
		window.parent.closeWin();
	}
	</script>
</body>
</html>