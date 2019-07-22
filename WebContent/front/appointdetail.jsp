<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>订单详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"  name="viewport" />
<meta name="author" content="钟文锋" />
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
        <div class="col-xs-10">定制之旅</div>
    </div>
</div>
</div><!--//.otop-->
<div class="otitle">
	<div class="container">产品信息</div>
</div><!--//.otitle-->
<div class="container">
	<div class="cpinfo">
    	<p>目标城市:${a.appointDest }</p>
    	<p>出发时间:${a.appointTime }</p>
        <p>预计行程天数:
        	<c:if test="${a.appointDay==0 }">不确定</c:if>
			<c:if test="${a.appointDay==1 }">不确定</c:if>
			<c:if test="${a.appointDay==2 }">1-7天</c:if>
			<c:if test="${a.appointDay==3 }">7-30天</c:if>
			<c:if test="${a.appointDay==4 }">30天以上</c:if>
        </p>
        <p>大人数:${a.appointAdult }</p>
        <p>小孩数:${a.appointChild }</p>
    </div><!--//.cpinfo-->
</div>
<div class="otitle">
	<div class="container">联系人信息</div>
</div><!--//.otitle-->
<div class="container">
	<div class="lxrinfo">
    	<div class="row">
        	<div class="col-xs-3">姓名</div>
            <div class="col-xs-9">${a.appointName }</div>
        </div>
        <div class="row">
        	<div class="col-xs-3">联系电话</div>
            <div class="col-xs-9">${a.appointTel }</div>
        </div>
    </div><!--//.lxrinfo-->
</div>
<div class="otitle">
	<div class="container">订单状态</div>
</div><!--//.otitle-->
<div class="container">
	<div class="cpinfo">
    	<p>订单状态:
			<c:if test="${a.appointStatus==0 }">未完成</c:if>
			<c:if test="${a.appointStatus==1 }">已完成</c:if>
		</p>
    </div><!--//.cpinfo-->
</div>
</body>
</html>
