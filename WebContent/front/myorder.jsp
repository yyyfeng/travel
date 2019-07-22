<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我的订单</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"  name="viewport" />
<link rel="stylesheet" href="front/css/style.css">
<link type="text/css" rel="stylesheet" href="front/css/bootstrap.css">
<script type="text/javascript" src="front/js/jquery.min.js"></script>
<script type="text/javascript" src="front/js/common.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->

<link rel="stylesheet" type="text/css" href="front/css/manhuaDate.1.0.css">    

</head>
<body class="">
<div class="container">
	<div class="qtll">
    	<div class="row">
    	<div class="col-xs-2"><a href="front/myoujia.jsp" ><img src="front/images/ico/ico_back.png" width="35" alt=""></a></div>
        <div class="col-xs-8 ptllcon">——<span>订单中心</span>——</div>
        <div class="col-xs-2"><a href="javascript::" onclick="sai()"></a></div>
        </div>
    </div><!--//.qtll-->
</div>
<div class="myo_nav">
	<div class="row">
    	<div class="col-xs-3 cur"><a  href="dingdan?op=QueryAll" >全部</a></div>
        <div class="col-xs-3"><a href="dingdan?op=NotDo">未完成</a></div>
        <div class="col-xs-3"><a href="dingdan?op=Completed">已完成</a></div>
        <div class="col-xs-3"><a  href="dingdan?op=Dingzhi" >我的定制</a></div>
    </div>
</div><!--//.oc_nav-->
<div class="myo" ">
		<c:if test="${order==null }">
			<p>没有订单</p>
		</c:if>
		<c:if test="${order!=null }">
			<c:forEach items="${order }" var="o">
				<div class="myolist">
			        <div class="container">
			        	<div class="myotitle">
			            	<div class="row">
			                	<div class="col-xs-5 txl">
			                		<c:if test="${o.tripMenu==1 }">
			                			定制之旅
			                		</c:if>
			                		<c:if test="${o.tripMenu!=1 }">
			                			轻奢之旅
			                		</c:if>
			                	</div>
			                    <div class="col-xs-7 txr">${o.createTime }</div>
			                </div>
			            </div>
			            <div class="myotll"><a href="dingdan?op=detail&orderId=${o.orderId }">${o.tripName }</a></div>
			            <div class="myoinfo">订单编号：${o.orderId }</div>
			         </div>       
			    </div><!--//.myolist-->
		</c:forEach>
		</c:if>
</div><!--//.myo-->
</body>
</html>
