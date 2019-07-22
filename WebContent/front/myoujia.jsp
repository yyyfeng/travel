<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我的游加</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"  name="viewport" />
<link rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body class="">
<div class="ibanner">
	<div class="ibposi">
    	<div class="container">
        	<div class="row">
                <div class="col-xs-6 txl"><a href="../index?op=index" onClick="history(-1)"><img src="images/ico/ico_back.png" width="35" alt=""></a></div>
                <div class="col-xs-6 txr"></div>
            </div>
        </div>
    </div><!--//.ibposi-->
    <div class="ibcon"><img src="images/mybanner.jpg" alt="" width="100%"></div><!--//.ibcon-->
</div><!--//.ibanner-->
<div class="container">
	<div class="row">
    	<div class="col-xs-12 txc"><a href="pcenter.jsp"><img src="images/cyxx.jpg" alt=""></a></div>
        <div class="col-xs-12 txc"><a href="../dingdan?op=QueryAll"><img src="images/wddd.jpg" alt=""></a></div>
        <div class="col-xs-12 txc"><input type="submit" onclick="javascript:window.location.href='../user?op=exit'" value="退出登录" class="sub_out"></div>
    </div>
</div>
</body>
</html>
