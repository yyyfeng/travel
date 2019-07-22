<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加主题</title>
<link href="easyui/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="easyui/themes/icon.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.all.min.js"></script>
</head>
<body>
	<%Object obj = request.getAttribute("ERRO");
		if(obj != null){ %>
			<div style="text-align:left; color:red"><%=obj %></div>
		<% }
	%>
	
	<form id="ff" action="menu?op=add" method="post">
		<div>
			<input type="hidden" id="ip" name="menuImg">
		</div>
		<div>
			主题标题:<input type="text" id="menuDesc" name="menuDesc"  placeholder="主题标题">
		</div>
		<div>
			主题图片:<span id="span"></span><input onclick="uploadImg()"   value="上传图片" type="button">
			<script id="img" type="text/plain"></script>
		</div>
		<div>
			<input type="button" onclick="sub()" value="提交">
		</div>
		
	</form>
	<script type="text/javascript">
		  var ue = UE.getEditor('img');
		  var src ="";
		  function uploadImg(){
			  var image = ue.getDialog("insertimage");
			  image.open();
		  }
		  ue.ready(function(){
			  ue.hide();
			  ue.addListener("afterInsertImage",function(t,arg){
				  src = arg[0].src;
				  $("#span").html("<img  src='/travel/"+src+"' width='50' height='50'/>");
				 	$("#ip").val(src);
			  })
		  })
		  
		  function sub(){
			  document.getElementById("ff").submit();
			  window.parent.closeWin();
		  }
		</script>
</body>
</html>