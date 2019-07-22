<%@page import="group5.travel.pojo.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主题修改</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.all.min.js"></script>
</head>
<body>
	<form id="ff" >
		<input type="hidden" id="menuId" >
		<input type="hidden" id="menuImg"  >
		<div>
			主题标题:<input type="text" id="menuDesc" name="menuDesc"  placeholder="主题标题">
		</div>
		<div>
			主题图片:<span id="span"></span><input onclick="uploadImg()"   value="上传图片" type="button">
			<script id="img" type="text/plain"></script>
		</div>
		<div>
			<input type="button" onclick="sub()"  value="提交">
		</div>
	</form>
	<script type="text/javascript">
			
		  var ue = UE.getEditor('img');
		  function uploadImg(){
			  var image = ue.getDialog("insertimage");
			  image.open();
		  }
		  ue.ready(function(){
			  ue.hide();
			  ue.addListener("afterInsertImage",function(t,arg){
				  src = arg[0].src;
				  $("#span").html("<img  src='/travel/"+src+"' width='50' height='50'/>");
				  $("#menuImg").val(src);
			  })
		  })
		   function sub(){
			  var menuDesc = $("#menuDesc").val();
			  var menuId = $("#menuId").val();
			  var menuImg = $("#menuImg").val();
			  console.log(menuImg);
			  $.ajax({
				  type:"GET",
				  url:"menu?op=edit",
				  data:{menuId:menuId,menuDesc:menuDesc,menuImg:menuImg},
				  success:function(data){
					  if(data=="1"){
							window.parent.closeWin();
					  }else{
						  alert("编辑失败");
					  }
				  }
			  })
		  }
	</script>
</body>
</html>