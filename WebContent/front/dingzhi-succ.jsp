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
<meta name="format-detection" content="telephone=no">
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
			Left : -150,//弹出时间停靠的左边位置
			Top : 0,//弹出时间停靠的顶部边位置
			fuhao : "-",//日期连接符默认为-
			isTime : false,//是否开启时间值默认为false
			beginY : 2016,//年份的开始默认为1949
			endY : 2017
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
	<h4>
		<span></span>
	</h4>
	<div class="dzbot">
		<input type="submit" value="预约定制" class="sub_dz">
	</div>
	<!--//.dzbot-->
	<div class="dztitle">
		<div class="container">
			<div class="os_img">
				<img src="images/o_success.png" alt="">
				<div class="ostll">预定成功</div>
				<a href="index.jsp">点击此处</a>返回<a href="index.jsp">主界面</a>
				<div class="oswtll">温馨提示：</div>
				<div class="oswinfo">
					非常感谢您的预订<br> 稍后我们工作人员就会跟您联系<br> 如果您有其他问题可以联系客服<br>
					客服电话：400-705-1815
				</div>
			</div>

			<!--//.dztll-->
		</div>
	</div>
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
				<a href="../trip?op=detail&tripId=${trip.tripId}"><img style="width: 640px" src="${trip.tripImg }" alt="nihao" /></a>
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
	</script>
	
</body>
</html>

