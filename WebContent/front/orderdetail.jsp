<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>订单详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"  name="viewport" />
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="front/css/style.css">
<link type="text/css" rel="stylesheet" href="front/css/bootstrap.css">
<script type="text/javascript" src="front/js/jquery.min.js"></script>
<script type="text/javascript" src="front/js/common.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->

</head>
<body class="">
<div class="otop">
<div class="container">
	<div class="row">
    	<div class="col-xs-2 pdrnone"><a href="dingdan?op=QueryAll" ><img src="front/images/ico/ico_back.png" width="35" alt=""></a></div>
        <div class="col-xs-10">${map.trip.tripName }</div>
    </div>
</div>
</div><!--//.otop-->
<div class="otitle">
	<div class="container">订单信息</div>
</div><!--//.otitle-->
<div class="container">
	<div class="omsgbox">
    	<div class="row">
        	<div class="col-xs-4 pdrnone"><img src="${map.trip.tripImg }" alt=""></div>
            <div class="col-xs-8">
            	<p>订单编号:${map.order.orderId }</p>
                <p>产品编号:${map.trip.tripId }</p>
                <p>下单时间:${map.order.createTime }</p>
                <p>订单金额:${map.order.orderCost } 元</p>
                <p>订单状态:
                	<c:if test="${map.order.orderStatus==0 }">
                		未完成
                	</c:if>
                	<c:if test="${map.order.orderStatus==1 }">
                		已完成
                	</c:if>
                </p>
            </div>
        </div>
    </div><!--//.omsgbox-->
</div>
<div class="otitle">
	<div class="container">产品信息</div>
</div><!--//.otitle-->
<div class="container">
	<div class="cpinfo">
    	<p>出发日期:${map.order.startTime }</p>
        <p>目的地:${map.trip.tripDest }</p>
    </div><!--//.cpinfo-->
</div>
<div class="otitle">
	<div class="container">联系人信息</div>
</div><!--//.otitle-->
<div class="container">
	<div class="lxrinfo">
	<div class="row">
        	<div class="col-xs-3 ">用户编号</div>
            <div class="col-xs-9">${map.user.userId }</div>
        </div>
    	<div class="row">
        	<div class="col-xs-3">姓名</div>
            <div class="col-xs-9">${map.user.userName }</div>
        </div>
        <div class="row">
        	<div class="col-xs-3">手机</div>
            <div class="col-xs-9">${map.user.userTel }</div>
        </div>
        <div class="row">
        	<div class="col-xs-3">邮箱</div>
            <div class="col-xs-9">${map.user.userEmail }</div>
        </div>
        
    </div><!--//.lxrinfo-->
</div>
</body>
</html>
