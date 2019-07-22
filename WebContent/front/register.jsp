<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<base href="${pageContext.request.contextPath }/" />
<title>注册</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"
	name="viewport" />
<meta name="author" content="" />
<link rel="stylesheet" href="front/css/style.css">
<link type="text/css" rel="stylesheet" href="front/css/bootstrap.css">
<script type="text/javascript" src="front/js/jquery.min.js"></script>
<script type="text/javascript" src="front/js/common.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
<!--form美化-->
<script type="text/javascript" src="front/js/jquery-1.9.1.min.js"></script>
<!-- custom jquery-ui with  minimum requirements for Custom scroll bar -->
<script src="front/js/jquery-ui-1.10.2.custom.min.js"
	type="text/javascript"></script>

<!-- Fancy fields js & css files -->
<script src="front/js/fancyfields-1.2.min.js" type="text/javascript"></script>
<link href="front/css/fancyfields.css" rel="stylesheet" type="text/css" />

<!-- Fancy fields add-on for custom scroll bar -->
<script src="front/js/fancyfields.csb.min.js" type="text/javascript"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.all.min.js"></script>


<script type="text/javascript">
	
</script>
</head>
<body class="agree">
	<div class="container">
		<div class="tllcolse">
			<a href="front/index.jsp"><img
				src="front/images/ico/ico_close.png" alt=""></a>
		</div>
		<!--//.tllcolse-->
		<div class="alogo">
			<a href="front/index.jsp"><img src="front/images/logo1.png"
				alt=""></a>
		</div>
		<!--//.alogo-->
		<form action="user?op=regUser" method="post">
		<!-- 添加一个隐藏表单域，用来存放userImg -->
		<input type="hidden" id="userImg" name="userImg"/>
			<div class="lobox">
				<div class="container">
					<span id="regMsg"><p style="color: red; margin-left: 150px">${regError}</p></span>
					<div class="row lolist">
						<div class="col-xs-2">
							<img src="front/images/ico/ico_name.png" alt="">
						</div>
						<div class="col-xs-10 pdlnone ">
							<input type="text" id="nickName" name="nickName" class="txt_com"
								placeholder="昵称">
						</div>
					</div>
					<div class="row lolist">
						<div class="col-xs-2">
							<img src="front/images/ico/ico_name.png" alt="">
						</div>
						<div class="col-xs-10 pdlnone ">
							<input type="text" id="userName" name="userName" class="txt_com"
								placeholder="用户名">
						</div>
					</div>
					<div class="row lolist">
						<div class="col-xs-2">
							<img src="front/images/ico/ico_phone.png" alt="">
						</div>
						<div class="col-xs-10 pdlnone ">
							<input type="text" id="userTel" name="userTel" class="txt_com"
								placeholder="手机号">
						</div>
					</div>
					<div class="row lolist">
						<div class="col-xs-2">
							<img src="front/images/ico/ico_mail.png" alt="">
						</div>
						<div class="col-xs-10 pdlnone ">
							<input type="email" id="userEmail" name="userEmail"
								class="txt_com" placeholder="邮箱">
						</div>
					</div>
					<div class="row lolist">
						<div class="col-xs-2">
							<img src="front/images/ico/ico_pass.png" alt="">
						</div>
						<div class="col-xs-10 pdlnone ">
							<input type="password" id="userPass" name="userPass"
								class="txt_com" placeholder="密码">
						</div>
					</div>
					<div class="row lolist">
						<div class="col-xs-2">
							<img src="front/images/ico/ico_pass.png" alt="">
						</div>
						<div class="col-xs-10 pdlnone ">
							<input type="password" id="userPass1" name="userPass1"
								class="txt_com" placeholder="确认密码">
						</div>
					</div>

					<div class="row lolist">
						<div class="col-xs-2">
							<img src="front/images/ico/ico_name.png" alt="">
						</div>
						<div class="col-xs-2 pdlnone ">
							添加头像:<span id="span" style="width:30px;height: 30px;" ></span><input onclick="uploadImg()"
								value="上传图片" type="button" name="userImg">
							<script id="img" type="text/plain"></script>
						</div>
						<div class="col-xs-6">
						</div>
					</div>

				</div>
			</div>
			<!--//.lobox-->
			<div class="lopush">
				<div class="row">
					<div class="col-xs-6 txl">
						<input type="submit" class=" sub_com" value="注册">
					</div>
					<div class="col-xs-6 txr">
						<a class="sub2_com" href="front/login.jsp">登录</a>
					</div>
				</div>
			</div>
			<!--//.lopush-->
			<div class="lofoot demo">
				<input type="checkbox" checked> <a href="agreement.html">同意游加旅游网协议</a>
			</div>
			<!--//.lofoot-->
		</form>
	</div>
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
				  $("#span").html("<img  src='/travel"+src+"' width='50' height='50'/>");
				 	$("#userImg").val(src);
			  })
		  })
		</script>
</body>
</html>
