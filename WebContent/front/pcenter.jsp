<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<base href="${pageContext.request.contextPath }/" />
<title>个人资料</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"
	name="viewport" />
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="front/css/style.css">
<link type="text/css" rel="stylesheet" href="front/css/bootstrap.css">
<script type="text/javascript" src="front/js/jquery.min.js"></script>
<script type="text/javascript" src="front/js/common.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
<!--//.日历控件-->
<script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="front/js/manhuaDate.1.1.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.all.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#dateTime").manhuaDate({
			Event : "click",//可选				       
			Left : 0,//弹出时间停靠的左边位置
			Top : 0,//弹出时间停靠的顶部边位置
			fuhao : "-",//日期连接符默认为-
			isTime : false,//是否开启时间值默认为false
			beginY : 1960,//年份的开始默认为1949
			endY : 2017
		//年份的结束默认为2049
		});

	})
</script>
<style>
.calender {
	margin: 42px 0px !important;
	top: 0;
	width: 100%;
	left: 0;
	border: 0px #D6D6D6 solid;
	background: #fff;
	position: absolute;
	display: none;
	z-index: 999;
	border-collapse: separate;
	border-spacing: 1;
}
</style>
<!--form美化-->

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

<link rel="stylesheet" type="text/css"
	href="front/css/manhuaDate.1.0.css">

</head>
<body class="">
	<div class="container">
		<div class="qtll">
			<div class="row">
				<div class="col-xs-2">
					<a href="front/myoujia.jsp"><img
						src="front/images/ico/ico_back.png" width="35" alt=""></a>
				</div>
				<div class="col-xs-8 ptllcon">
					——<span>个人资料</span>——
				</div>
				<div class="col-xs-2">
					<a href="javascript::" onclick="sai()"></a>
				</div>
			</div>
		</div>
		<!--//.qtll-->
	</div>
	<div class="pmain">
		<form action="user?op=updateSelfInfo" method="post">
		<input type="hidden" id="userImg" name="userImg" value="${u.userImg }"/>
		<c:if test="${updateSucMsg!=null }">
		<span ><p style="color: red;text-align: center;">${updateSucMsg }</p> </span>
		</c:if>
		<c:if test="${updateErrorMsg!=null }">
		<span ><p style="color: red;text-align: center;">${updateErrorMsg }</p> </span>
		</c:if>
			<div class="pmlist">
				<div class="container">
					<div class="row">
						<div class="col-xs-4 txl">昵称</div>
						<div class="col-xs-8 txr">
							<input type="text" name="nickName" value="${u.nickName }"
								class="pc_text">
						</div>
					</div>
				</div>
			</div>
			<!--//.pmlist-->
			<div class="pmlist">
				<div class="container">
					<div class="row">
						<div class="col-xs-4 txl">姓名</div>
						<div class="col-xs-8 txr">
							<input type="text" name="userName" value="${u.userName }"
								class="pc_text">
						</div>
					</div>
				</div>
			</div>
			<!--//.pmlist-->
			<div class="pmlist">
				<div class="container">
					<div class="row">
						<div class="col-xs-4 txl">年龄</div>
						<div class="col-xs-8 txr">
							<input type="text" name="userAge" value="${u.userAge }"
								class="pc_text">
						</div>
					</div>
				</div>
			</div>
			<!--//.pmlist-->
			<div class="pmlist">
				<div class="container">
					<div class="row">
						<div class="col-xs-4 txl">手机号</div>
						<div class="col-xs-8 txr">
							<input type="text" name="userTel" value="${u.userTel }"
								class="pc_text">
						</div>
					</div>
				</div>
			</div>
			<!--//.pmlist-->
			<div class="pmlist">
				<div class="container">
					<div class="row">
						<div class="col-xs-4 txl">修改密码</div>
						<div class="col-xs-8 txr">
							<input type="password" name="userPass" value="${u.userPass }"
								class="pc_text">
						</div>
					</div>
				</div>
			</div>
			<!--//.pass_box-->
			<!--//.pmlist-->

			<div class="pmlist">
				<div class="container">
					<div class="row">
						<div class="col-xs-4 txl ">生日</div>
						<div class="col-xs-8 txr ">
							<div class="p_down">
								<div class="birthday">
									<input id="dateTime" type="text" name="userBirth"
										value="${u.userBirth }" date-time="2016-4-7" readonly>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--//.pmlist-->
			<div class="pmlist">
				<div class="container">
					<div class="row">
						<div class="col-xs-4 txl ">邮箱</div>
						<div class="col-xs-8 txr ">
							<input type="email" name="userEmail" value="${u.userEmail }"
								class="pc_text">
						</div>
					</div>
				</div>
			</div>
			<!--//.pmlist-->
			<div class="pmlist">
				<div class="container">
					<div class="row">
						<div class="col-xs-4 txl ">头像</div>
						<div class="col-xs-8 txr ">
							<img style="width: 40px;height: 40px;"   alt="" src="${u.userImg }">
							<input onclick="uploadImg()"
								value="更换头像" type="button" >
								<span id="span" ></span>
							<script id="img" type="text/plain"></script>
						</div>
					</div>
				</div>
			</div>
			<!--//.pmlist-->
			<div class="pmfoot">
				<div class="col-xs-12 txc">
					<input type="submit" class="pass_sub" onclick="window.location.href='user?op=exit'" value="保存">
				</div>
			</div>
		</form>
		<!--//.pmfoot-->
	</div>
	<!--//.pmain-->
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
