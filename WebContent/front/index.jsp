<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>U+旅游定制</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"
	name="viewport" />
<link rel="stylesheet" href="front/css/style.css">
<link type="text/css" rel="stylesheet" href="front/css/bootstrap.css">
<script type="text/javascript" src="front/js/jquery.min.js"></script>
<script type="text/javascript" src="front/js/common.js"></script>
<style type="text/css">
	#userImg{
		 margin-top: 0px; 
        width:35px; 
        height:35px; 
        border-radius:30px;
	}
</style>

<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body class="index">
	<div class="i_top">
		<div class="logo">
			<a href="index?op=index"><img src="front/images/logo.png" alt="登录/注册"></a>
		</div>
	</div>
	<!--//.i_top-->
	<div class="ibanner">
		<div class="ibposi">
			<div class="container">
				<div class="row">
					<div class="col-xs-2 txl">
						<a href="javascript::"><img src="front/images/ico/ico13.png" alt=""></a>
					</div>
					<div class="col-xs-8"></div>
					<div class="col-xs-2 txr">
						<c:choose>
							<c:when test="${u!=null }">
								<a href="front/myoujia.jsp" style="color: white"><img id="userImg" alt="" src="${u.userImg }"><br>${u.nickName }</a>
								
							</c:when>
							<c:when test="${u==null }">
								<a href="front/login.jsp"><img style="color: white;" src="front/images/ico/ico14.png"
									alt=""><br><p style="color: white;">登陆/注册</p></a>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		<!--//.ibposi-->
		<div class="ibcon">
			<a href="front/dingzhi.jsp"><img src="front/images/i_top.jpg" alt=""
				width="100%"></a>
		</div>
		<!--//.ibcon-->
	</div>
	<!--//.ibanner-->
	<div class="itheme">
		<div class="container">
			<div class="ititle">
				<img src="front/images/tll_lxzt.jpg" alt="">
			</div>
			<!--//.ititle-->
			<div class="itmcon">
				<div class="row">
					<c:if test="${map.menu==null }">
						<p>暂无主题敬请期待!</p>
					</c:if>
					<c:if test="${map.menu!=null }">
						<c:forEach items="${map.menu }" var="m">
							<div class="col-xs-3">
								<!-- 超链接用于查找同样主题下的商品 -->
								<a href="trip?op=detaillist&menuId=${m.menuId }"><img src="${m.menuImg }" >${m.menuDesc }</a>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
			<!--//.itmcon-->
		</div>
	</div>
	<!--//.itheme-->
	<!-- 当季推荐 -->
	<div class="irecom">
		<div class="container">
			<div class="ititle">
				<img src="front/images/tll_djtj.jpg" alt="">
			</div>
			<!--//.ititle-->
			<div class="irmbox">
				<ul>
					<c:if test="${map.trip==null }">
						<h1 align="center">暂无商品,敬请期待!</h1>
					</c:if>
					<c:if test="${map.trip!=null }">
					
						<c:forEach items="${map.trip }" var="t">
							<li>
								<div class="irm_img">
									<a href="trip?op=detail&tripId=${t.tripId }"><img src="${t.tripImg }" width="610"></a>
								</div> <!--//.irm_img-->
								<div class="irm_con" >
									<div class="irm_title" >
									<!-- 超链接用于查询商品详情 -->
										<a href="trip?op=detail&tripId=${t.tripId }">${t.tripName }</a>
									</div>
									<!--//.irm_title-->
									<div class="irm_info">${t.tripDesc }</div>
								</div> <!--//.irm_con-->
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
			<!--//.irmbox-->
			<c:if test="${map.st==2 }">
		    	<div class="irm_more">
					<a href="javascript::"><img src="front/images/ico/ico_down.png" alt="">查看更多</a>
				</div>
    	</c:if>
		</div>
	</div>
	<!--//.irecom-->
	<div class="icomp">
		<!--<div class="container">
    	<ul>
        	<li>
            	<div class="row">
                	<div class="col-xs-4"><img src="images/ico/ico09.png" alt="">专业</div>
                    <div class="col-xs-8">定制师均拥有五年以上<br>目的地定制经验</div>
                </div>
            </li>
            <li>
            	<div class="row">
                 	<div class="col-xs-4"><img src="images/ico/ico10.png" alt="">无忧</div>
                    <div class="col-xs-8">7×24小时<br>全球紧急顾问服务</div>
                </div>
            </li>
            <li>
            	<div class="row">
                	<div class="col-xs-4"><img src="images/ico/ico11.png" alt="">实践</div>
                    <div class="col-xs-8">全球40多个国家实地探路<br>定制当地最佳旅游方案</div>
                </div>
            </li>
            <li>
            	<div class="row">
                	<div class="col-xs-4"><img src="images/ico/ico15.png" alt="">私享</div>
                    <div class="col-xs-8">全球合作关系<br>为您提供更多私享VIP体验</div>
                </div>
            </li>
        </ul>
    </div>-->
		<img src="front/images/icomp_01.jpg" alt=""> <img
			src="front/images/icomp_02.jpg" alt=""> <img
			src="front/images/icomp_03.jpg" alt=""> <img
			src="front/images/icomp_04.jpg" alt="">
	</div>
	<!--//.icomp-->
	<div class="partner">
		<div class="container">
			<div class="ipartll">
				<span>合作关系（部分）</span>
			</div>
			<!--//.ipartll-->
			<div class="iparcon">
				<ul>
					<li><img src="front/images/part_01.jpg" alt=""></li>
					<li><img src="front/images/part_02.jpg" alt=""></li>
					<li><img src="front/images/part_03.jpg" alt=""></li>
					<li><img src="front/images/part_04.jpg" alt=""></li>
					<li><img src="front/images/part_05.jpg" alt=""></li>
					<li><img src="front/images/part_06.jpg" alt=""></li>
					<li><img src="front/images/part_07.jpg" alt=""></li>
					<li><img src="front/images/part_08.jpg" alt=""></li>
					<li><img src="front/images/part_09.jpg" alt=""></li>
					<li><img src="front/images/part_10.jpg" alt=""></li>
					<li><img src="front/images/part_11.jpg" alt=""></li>
					<li><img src="front/images/part_12.jpg" alt=""></li>
					<li><img src="front/images/part_13.jpg" alt=""></li>
					<li><img src="front/images/part_14.jpg" alt=""></li>
					<li><img src="front/images/part_15.jpg" alt=""></li>
				</ul>
			</div>
			<!--//.iparcon-->
		</div>
	</div>
	<!--//.partner-->
	<div class="ileft">
		<img src="front/images/ico/ico12.png" alt="">
	</div>
	<div class="ileftcon">
		<div class="container">
			<div class="row">
				<div class="col-xs-2"></div>
				<div class="col-xs-4 pdlnone">
					<a href="trip?op=detaillist&menuId=1" class="ilg">轻奢之旅</a>
				</div>

				<div class="col-xs-4 pdrnone">
					<a href="front/dingzhi.jsp" class="ilg">定制之旅</a>
				</div>
				<div class="col-xs-2">
					<!-- <a href="front/address.html" class="ilser"></a> -->
				</div>
			</div>
		</div>
	</div>
	<div class="imark"></div>
</body>
</html>
