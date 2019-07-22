<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>订单详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"  name="viewport" />
<link rel="stylesheet" href="front/css/style.css">
<link type="text/css" rel="stylesheet" href="front/css/bootstrap.css">
<link rel="stylesheet" href="front/js/spinner/css/jquery.spinner.css" >
<link rel="stylesheet" type="text/css" href="front/css/manhuaDate.1.0.css">
<script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="front/js/common.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="front/js/spinner/js/jquery.spinner.js"></script>
<script type="text/javascript" src="front/js/manhuaDate.1.0.js"></script>
<script type="text/javascript">
	$(function(){
    	$('.spinnerExample').spinner({});
		$("#dateTime").manhuaDate({					       
			Event : "click",//可选				       
			Left : 0,//弹出时间停靠的左边位置
			Top : -16,//弹出时间停靠的顶部边位置
			fuhao : "-",//日期连接符默认为-
			isTime : false,//是否开启时间值默认为false
			beginY : 2018,//年份的开始默认为1949
			endY :2025//年份的结束默认为2049
		});
	})
</script>
<style>
.calender{  margin:42px 15px !important; top:0;  left:0; border:0px #D6D6D6 solid; background:#fff; position:absolute; display:none; z-index:999;border-collapse: separate;border-spacing: 1;}
</style>

</head>
<body class="">
	<% pageContext.setAttribute("date", new Date()); %>
	<c:set var="now" value="${date }"/>
<div class="otop">
<div class="container">
	<div class="row">
    	<div class="col-xs-2 pdrnone"><a href="trip?op=detail&tripId=${trip.tripId }" onClick="history(-1)"><img src="front/images/ico/ico_back.png" width="35" alt=""></a></div>
        <div class="col-xs-10">${trip.tripName }</div>
    </div>
</div>
</div><!--//.otop-->
<form>
<div class="otmain">
	<div class="container">
    	<div class="ottll">请填写您的订单信息</div><!--//.ottll-->
        <div class="otlist">
        	<div class="col-xs-4"><span>出发时间</span></div>
            <div class="col-xs-8 otdate"><input type="text"  id="dateTime" value="<fmt:formatDate type="date" value="${now }"/>"  date-time="2016-4-7,2016-4-8,2016-4-17,2016-4-18" readonly></div>
        </div><!--//.otlist-->
         <div class="otlist">
        	<div class="col-xs-4"><span>出发人数</span></div>
            <div class="col-xs-4 otgrey" id="cr">成人<input id="a_num" type="text" readonly class="spinnerExample" value="0"/>12周岁以上</div>
            <div class="col-xs-4 otgrey" id="et">儿童<input id="c_num" type="text" readonly class="spinnerExample" value="0"/>0-12周岁</div>
        </div><!--//.otlist-->
        <div class="otinfo">
            <div class="otinfolist">
                <div class="container"><div class="otinfotll">订单信息</div></div>
            </div><!--//.otinfolist-->
            <div class="otinfolist">
                <div class="container"><div class="col-xs-12">${trip.tripDesc }</div></div>
            </div><!--//.otinfolist-->
            <div class="otinfolist">
                <div class="container"><div class="col-xs-12">出发日期：<span name="startTime" id="result-date"><fmt:formatDate type="date" value="${now }"/></span></div></div>
            </div><!--//.otinfolist-->
            <div class="otinfolist">
                <div class="container"><div class="col-xs-12">人数：成人 x<span name="adultNum" id="getcr" >0</span>&nbsp;&nbsp;&nbsp;    儿童    x<span name="childNum" id="getet">0</span></div></div>
            <div class="otinfolist">
                <div class="container"><div class="col-xs-12">订单金额：<span name="orderCost" id="orderCost">0</span></div></div>
            </div><!--//.otinfolist-->    
            </div><!--//.otinfolist-->
        </div><!--//.otinfo-->
        <input type="hidden" name="tripId" id="tripId" value="${trip.tripId }">
        <input type="hidden" name="userId" id="userId" value="${u.userId }">
        <div class="otfoot txr"><input type="button" class="sub_ot" onclick="sub()" value="立即预定"></div>
    </div>
</div><!--//.otmain-->
</form>
<script type="text/javascript">
	function changeCost(value){
		var a=$("#a_num").val();
		var c=$("#c_num").val();
		var t_c=${trip.tripCost };
		console.log("成人数："+a+";儿童数:"+"行程单价"+t_c);
		document.getElementById("orderCost").innerText=parseFloat(a)*parseFloat(t_c)+parseFloat(c)*parseFloat(t_c)*0.5;
	}

	function sub(){
		var tripId = $("#tripId").val();
		var userId = $("#userId").val();
		var startTime = document.getElementById("result-date").innerText;
		var adultNum = document.getElementById("getcr").innerText;
		var childNum = document.getElementById("getet").innerText;
		var orderCost = document.getElementById("orderCost").innerText;
		console.log(startTime)
		console.log("tripId"+tripId)
		console.log(adultNum)
		console.log(childNum)
		$.ajax({
			type:"GET",
			url:"order?op=confirm",
			data:{startTime:startTime,adultNum:adultNum,childNum:childNum,tripId:tripId,userId:userId,orderCost:orderCost},
			success:function(data){
				console.log(data);
					if (data=1) {
					window.location.href="front/success.html";
				}else{
					window.location.href="front/fail.html";
				}
			} 
		})
	}
</script>
</body>
</html>
