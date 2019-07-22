<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>个人资料</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"
	name="viewport" />
<meta name="author" content="" />
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
<script type="text/javascript">
	$(function(){
    	
		$("#dateTime").manhuaDate({					       
			Event : "click",//可选				       
			Left : 0,//弹出时间停靠的左边位置
			Top : 0,//弹出时间停靠的顶部边位置
			fuhao : "-",//日期连接符默认为-
			isTime : false,//是否开启时间值默认为false
			beginY : 1960,//年份的开始默认为1949
			endY :2017//年份的结束默认为2049
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
<script src="js/jquery-ui-1.10.2.custom.min.js" type="text/javascript"></script>

<!-- Fancy fields js & css files -->
<script src="front/js/fancyfields-1.2.min.js" type="text/javascript"></script>
<link href="front/css/fancyfields.css" rel="stylesheet" type="text/css" />

<!-- Fancy fields add-on for custom scroll bar -->
<script src="front/js/fancyfields.csb.min.js" type="text/javascript"></script>


<script type="text/javascript">
        $(document).ready(function () {
            $(".demo").fancyfields();
            $(".customSBDemo").fancyfields({ customScrollBar: true });

            $("#demoReset").click(function () {
                $(".demo").fancyfields("reset");
                $(".customSBDemo").fancyfields("reset");
            });
            
            
        });
        
	</script>

<link rel="stylesheet" type="text/css"
	href="front/css/manhuaDate.1.0.css">

</head>
<body class="">
	<div id="edit">
		<form  action="user?op=saveEditUser" method="post">
		  <input type="hidden" id="userId" name="userId" />
			<div class="container">
				<div class="qtll">
					<div class="row">
						<div class="col-xs-2">
							<a href="userList.jsp"><img
								src="front/images/ico/ico_back.png" width="35" alt=""></a>
						</div>
						<div class="col-xs-8 ptllcon">
							——<span>修改用户</span>——
						</div>
						<div class="col-xs-2">
							<a href="javascript::" onclick="sai()"></a>
						</div>
					</div>
				</div>
				<!--//.qtll-->
			</div>
			<div class="pmain">
				<div class="pmlist">
					<div class="container">
						<div class="row">
							<div class="col-xs-4 txl">昵称：</div>
							<div class="col-xs-8 txl">
								<input type="text" class="pc_text" id="nickName" name="nickName" values="">
							</div>
						</div>
					</div>
				</div>
				<!--//.pmlist-->
				<div class="pmlist">
					<div class="container">
						<div class="row">
							<div class="col-xs-4 txl">姓名：</div>
							<div class="col-xs-8 txl">
								<input type="text" class="pc_text" id="userName" name="userName">
							</div>
						</div>
					</div>
				</div>
				<!--//.pmlist-->
				<div class="pmlist">
					<div class="container">
						<div class="row">
							<div class="col-xs-4 txl">年龄：</div>
							<div class="col-xs-8 txl">
								<input type="text" class="pc_text"id="userAge" name="userAge">
							</div>
						</div>
					</div>
				</div>
				<!--//.pmlist-->
				<div class="pmlist">
					<div class="container">
						<div class="row">
							<div class="col-xs-4 txl">手机号：</div>
							<div class="col-xs-8 txr">
								<input type="text" class="pc_text" id="userTel" name="userTel">
							</div>
						</div>
					</div>
				</div>
				<!--//.pmlist-->
				<div class="pmlist">
					<div class="container">
						<div class="row">
							<div class="col-xs-4 txl">密码：</div>
							<div class="col-xs-8 txr">
								<input type="password" class="pc_text" id="userPass" name="userPass">
							</div>
						</div>
					</div>
				</div>
				<!--//.pmlist-->
				<div class="pmlist">
					<div class="container">
						<div class="row">
							<div class="col-xs-4 txl ">生日：</div>
							<div class="col-xs-8 txr ">
								<div class="p_down">
									<div class="birthday">
										<input id="dateTime" type="text" id="userBirth" name="userBirth" date-time="2016-4-7" readonly>
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
							<div class="col-xs-4 txl ">邮箱：</div>
							<div class="col-xs-8 txr ">
								<input type="email" class="pc_text" id="userEmail" name="userEmail">
							</div>
						</div>
					</div>
				</div>
				<!--//.pmlist-->
				<div class="pmfoot">
					<div class="col-xs-12 txc">
						<input type="submit" onclick="sub()"  class="pass_sub" value="确认修改">
					</div>
				</div>
				<!--//.pmfoot-->
			</div>
			<!--//.pmain-->
		</form>
	</div>
	<script type="text/javascript">
	//添加一个表单提交的事件,提交表单时将窗口关闭
	function sub(){
		window.parent.closeWin();
	}
</script>
</body>
</html>
