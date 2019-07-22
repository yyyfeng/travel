<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<base href="${pageContext.request.contextPath }/front/" />
<title>定制之旅</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"
	name="viewport" />
<link rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
<!--//.日历控件-->
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/manhuaDate.1.0.js"></script>
<script type="text/javascript">
	$(function() {

		$("#dateTime").manhuaDate({
			Event : "click",//可选				       
			Left : 0,//弹出时间停靠的左边位置
			Top : 0,//弹出时间停靠的顶部边位置
			fuhao : "-",//日期连接符默认为-
			isTime : false,//是否开启时间值默认为false
			beginY : 1949,//年份的开始默认为1949
			endY : 2019
		//年份的结束默认为2049
		});
	})
</script>
<!--form美化-->

<!-- custom jquery-ui with  minimum requirements for Custom scroll bar -->
<script src="js/jquery-ui-1.10.2.custom.min.js" type="text/javascript"></script>

<!-- Fancy fields js & css files -->
<script src="js/fancyfields-1.2.min.js" type="text/javascript"></script>
<link href="css/fancyfields.css" rel="stylesheet" type="text/css" />

<!-- Fancy fields add-on for custom scroll bar -->
<script src="js/fancyfields.csb.min.js" type="text/javascript"></script>


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

<link rel="stylesheet" type="text/css" href="css/manhuaDate.1.0.css">
</head>
<body class="">
	<form action="../appoint?op=save" method="post">
		<input type="hidden" name="mdd1" id="mdd1"> <input
			type="hidden" name="mdd2" id="mdd2">
		<div class="dtop">
			<div class="container">
				<div class="odtop">
					<div class="row">
						<div class="col-xs-2 ">
							<a href="index.jsp"><img src="images/ico/ico_back.png" alt=""></a>
						</div>
						<div class="col-xs-10">专属旅游顾问 让您轻松预约</div>
					</div>
				</div>
				<!--//.odtop-->
				<div class="dform">

					<div class="row">
						<div class="col-xs-6">
							<input type="text" name="appointName" class="dz_txt"
								placeholder="姓名">
						</div>
						<div class="col-xs-6">
							<input type="text" name="appointTel" class="dz_txt"
								placeholder="手机号">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 ">
							<input type="text" name="appointDest" class="dz_txt"
								placeholder="目的地(若无明确目的地，可不填写!)">
						</div>

					</div>
					<div class="row">
						<div class="col-xs-6 demo">
							<select name="appointDay">
								<option value="0">出行天数</option>
								<option value="1">不确定</option>
								<option value="2">1-7天</option>
								<option value="3">7-30天</option>
								<option value="4">30天以上</option>
							</select>
						</div>
						<div class="col-xs-6 demo">
							<input type="text" class="dz_txt" id="dateTime"
								name="appointTime" placeholder="出发日期"
								date-time="2016-4-7,2016-4-8,2016-4-17,2016-4-18" readonly>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 demo">
							<select name="appointAdult">

								<option value="0">不确定(成人)</option>
								<option value="1">1人(成人)</option>
								<option value="2">2人(成人)</option>
								<option value="3">3人(成人)</option>
								<option value="4">4人(成人)</option>
								<option value="5">5人以上(成人)</option>
							</select>
						</div>
						<div class="col-xs-6 demo">
							<select name="appointChild">

								<option value="0">不确定(儿童)</option>
								<option value="1">1人(儿童)</option>
								<option value="2">2人(儿童)</option>
								<option value="3">3人(儿童)</option>
								<option value="4">4人(儿童)</option>
								<option value="5">5人以上(儿童)</option>
							</select>
						</div>
					</div>

				</div>
				<!--//.dform-->
			</div>
		</div>
		<!--//.dtop-->
		<div class="dzbot">
			<input type="submit" value="预约定制" class="sub_dz">
		</div>
		<!--//.dzbot-->

		<!--//.dztitle-->
	</form>

	<!-- Swiper -->
	<link rel="stylesheet" href="css/swiper.min.css">
	<div>
		<h2 style="color: #B49E86;">今日推荐:</h2>
	</div>
	<div class="swiper-container">

		<div class="swiper-wrapper">
		<c:forEach items="${trips }" var="trip">
			<div class="swiper-slide">
				<a href="../trip?op=detail&tripId=${trip.tripId}"><img style="width: 640px" height="376" src="${trip.tripImg }" alt="nihao" /></a>
				${trip.tripName }
			</div>
			</c:forEach>
		</div>
		<!-- Add Pagination -->
		<div class="swiper-pagination"></div>
		<!-- Add Pagination -->
		<!-- <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>-->
	</div>
		<!-- Add Pagination -->
		<!--<div class="swiper-pagination"></div>-->
		<!-- Add Pagination -->
		<!-- <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>-->
	</div>

	<!-- Swiper JS -->
	<script src="js/swiper.min.js"></script>
	<!-- Initialize Swiper -->
	<script>
		var swiper = new Swiper('.swiper-container', {
			pagination : '.swiper-pagination',
			paginationClickable : true,
			nextButton : '.swiper-button-next',
			prevButton : '.swiper-button-prev',
			autoHeight : true, //enable auto height
			paginationClickable : true,
			spaceBetween : 30,
			centeredSlides : true,
			autoplay : 5000,
			autoplayDisableOnInteraction : false
		});
		$(".osbox").css("margin-top", -$(".osbox").height() / 2)
	</script>
</body>
</html>
