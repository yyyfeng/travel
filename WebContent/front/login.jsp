<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<meta charset="utf-8">
<title>登录与验证</title>
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


<script type="text/javascript">
	$(document).ready(function() {
		$(".demo").fancyfields();
		$(".customSBDemo").fancyfields({
			customScrollBar : true
		});

		$("#demoReset").click(function() {
			$(".demo").fancyfields("reset");
			$(".customSBDemo").fancyfields("reset");
		});
	});
</script>
</head>
<body class="agree">

	<div class="container">
		<div class="tllcolse">
			<a href="front/index.jsp"><img src="front/images/ico/ico_close.png"
				alt=""></a>
		</div>
		<!--//.tllcolse-->
		<div class="alogo">
			<a href="front/index.jsp"><img src="front/images/logo1.png"
				alt=""></a>
		</div>
		<!--//.alogo-->
		<form action="user?op=checkEmailAndLogin" method="post">
			<input type="hidden" name="uri" value="${param.uri }">
			<div class="lobox1">
				<div class="lonav">
					<div class="zhdl cur col-xs-6">账号登录</div>
					<div class="sjdl  col-xs-6">邮箱验证</div>

				</div>
				<!--//.lonav-->
				<div class="lonavbox">
					<div class="container">
						<!--  -->
						<c:choose>
							<c:when test="${errorMsg==null}">
								<span><p style="color: red; margin-left: 150px">${sucMsg}</p></span>
							</c:when>
							<c:when test="${errorMsg!=null}">
								<span><p style="color: red; margin-left: 150px">${errorMsg}</p></span>
							</c:when>
							<c:when test="${regSucMsg!=null}">
								<span><p style="color: red; margin-left: 150px">${regSucMsg}</p></span>
								<!--  ${regSucMsg}-->
							</c:when>
							<c:when test="${updateErrorMsg==null}">
								<span><p style="color: red; margin-left: 150px">${updateSucMsg}</p></span>
							</c:when>
						</c:choose>
						<div class="row lolist">
							<div class="col-xs-2">
								<img src="front/images/ico/ico_name.png" alt="">
							</div>
							<div class="col-xs-10 pdlnone ">
								<input type="text" class="txt_com" id="loadMsg" name="loadMsg"
									placeholder="请输入用户名或邮箱">
							</div>
						</div>

						<div class="row lolist">
							<div class="col-xs-2">
								<img src="front/images/ico/ico_pass.png" alt="">
							</div>
							<div class="col-xs-10 pdlnone ">
								<input type="password" class="txt_com" id="userPass"
									name="userPass" placeholder="密码">
							</div>
						</div>

					</div>
					<div class="container" style="display: none;">
						<div class="row lolist">
							<div class="col-xs-2">
								<img src="front/images/ico/ico_mail.png" alt="">
							</div>
							<div class="col-xs-10 pdlnone ">
								<input type="email" class="txt_com" id="userEmail"
									name="userEmail" placeholder="邮箱">
							</div>
						</div>
						<div class="row lolist">
							<div class="col-xs-2">
								<img src="front/images/ico/ico_yzm.png" alt="">
							</div>
							<div class="col-xs-10 pdlnone ">
								<input type="text" class="txt_com" id="code" name="code"
									placeholder="请输入邮箱秘钥(区分大小写！)">
							</div>
						</div>
					</div>
				</div>
				<!--//.lonavbox-->
			</div>
			<!--//.lobox-->
			<div class="lopush">
				<div class="row">
					<div class="col-xs-6 txl">
						<a class=" sub2_com" href="front/register.jsp">注册</a>
					</div>
					<div class="col-xs-6 txr">
						<input type="submit" class="sub_com" value="登录">
					</div>
				</div>
			</div>
			<!--//.lopush-->
			<div class="foget">
				<a href="front/repass.html">忘记密码？</a>
			</div>
		</form>
	</div>
</body>
</html>
