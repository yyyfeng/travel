<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>轻奢之旅</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"  name="viewport" />
<link rel="stylesheet" href="front/css/style.css">
<link type="text/css" rel="stylesheet" href="front/css/bootstrap.css">
<script type="text/javascript" src="front/js/jquery.min.js"></script>
<script type="text/javascript" src="front/js/common.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body class="index " >
<div class="container">
	<div class="qtll">
    	<div class="row">
    	<div class="col-xs-2"><a href="index?op=index" ><img src="front/images/ico/ico_back.png" width="35" alt=""></a></div>
        <div class="col-xs-8 qtllcon"><img src="front/images/qstll.jpg" alt=""></div>
        <div class="col-xs-2 txr"><a href="javascript::" onclick="sai()"><img src="front/images/ico/ico_sai.png" alt=""></a></div>
        </div>
    </div><!--//.qtll-->
    <div class="qmain">
    	<ul onClick="closesai()">
	    	<c:if test="${map.str==0 }">
					<span><h1 align="center">暂无商品,敬请期待!</h1></span>
			</c:if>
    		<c:if test="${map.str==1 }">
    			<c:forEach items="${map.trip }" var="t">
    				<li>
		            	<div class="cour">${t.menuDesc }</div>
		            	<div class="q_img"><a href="trip?op=detail&tripId=${t.tripId }"><img src="${t.tripImg }" width="610" height="376"></a></div>
		                <div class="q_con">
		                	<div class="q_title"><a href="trip?op=detail&tripId=${t.tripId }">${t.tripName }</a></div>
		                	<div class="q_info">${t.tripDesc }</div>
		                </div><!--//.q_con-->
           			 </li>
    			</c:forEach>
    		</c:if>
        </ul>
    </div><!--//.qmain-->
    	<c:if test="${map.st==2 }">
	    	<div class="irm_more">
				<a href="javascript::"><img src="front/images/ico/ico_down.png" alt="">查看更多</a>
			</div>
    	</c:if>
</div>

<div class="ileft"><img src="front/images/ico/ico12.png" alt=""></div>
<div class="ileftcon">
<div class="container">
	<div class="row">
    	<div class="col-xs-2"></div>
        <div class="col-xs-4 pdlnone"><a href="trip?op=detaillist&menuId=1" class="ilg">轻奢之旅</a></div>
        
        <div class="col-xs-4 pdrnone"><a href="front/dingzhi.jsp" class="ilg">定制之旅</a></div>
        <!--<div class="col-xs-2"><a href="front/dizhi.html" class="ilser"></a></div>  -->
    </div>
</div>
</div>
<div class="imark"></div>
<form action="trip?op=choosetrip" method="post">
<div class="saitop">
	<div class="container">
        	<div class="row">
                <div class="col-xs-6 txl"><a href="trip?op=detaillist&menuId=1" onClick="closesai()"><img src="front/images/ico/ico_back.png" width="35" alt=""></a></div>
                <div class="col-xs-6 txr"><input type="submit" class="sai_btn" value=""></div>
                <input type="hidden" name="tripDest" id="Dest">
                <input type="hidden" name="tripDays" id="Days">
                <input type="hidden" name="menuDesc" id="Desc">
            </div>
        </div>
</div><!--//.saitop-->
</form>
<div class="saiboxbg1">

</div><!--//.saibox-->
<div class="saiboxbg2">

</div><!--//.saibox-->
	<div class="saibox">
		<div class="container">
			<div class="saitll">当季热门</div><!--//.saitll-->
	        <div class="saicon ">
	        	<div class="row rowt" id="tripDest">
	        	<c:forEach items="${map.tripList }" var="trip">
	        		<li class="col-xs-4"><a href="#" data-val="5" data-val2="5">${trip.tripDest }</a></li>			
	    		</c:forEach>
	             <li class="col-xs-4"><a href="front/dingzhi.jsp">定制旅行</a></li>
	            </div>
	        </div><!--//.saicon-->
	        <div class="saitll">天数</div><!--//.saitll-->
	        <div class="saicon">
	        	<div class="row rowtt" id="tripDays">
	            	<li class="col-xs-6" value="1"><a href="#" data-val="7">7天以内</a></li>
	                <li class="col-xs-6" value="2"><a href="#" data-val="8-14">8-14天</a></li>
	                <li class="col-xs-6 " value="3"><a href="#" data-val="15" class="cur">15天以上</a></li>
	            </div>
	        </div><!--//.saicon-->
	        <div class="saitll">主题</div><!--//.saitll-->
	        <div class="saicon">
	        	<div class="row rowtt" id="menuDesc">
	    			<c:forEach items="${map.menuList }" var="menu">
	    					<li class="col-xs-6"><a href="#">${menu.menuDesc }</a></li>
	    			</c:forEach>
	            </div>
	        </div><!--//.saicon-->
	    </div>
	</div><!--//.saibox-->
	<script type="text/javascript">
		//获取li标签中a标签的文本值
		var Dest=$("#tripDest li");
		Dest.click(function () {
		    var tripDest =  $(this).find("a").eq(0).text();
		    $("#Dest").val(tripDest);
		});
		 var Days=$("#tripDays li");
		 Days.click(function () {
		    var tripDays =  $(this).eq(0).val();
		    $("#Days").val(tripDays);
		});
		 var Desc=$("#menuDesc li");
		 Desc.click(function () {
		    var menuDesc =  $(this).find("a").eq(0).text();
		    $("#Desc").val(menuDesc);
		});
	</script>
</body>
</html>
<script type="text/javascript">
function sai(){
		$("body").addClass("sbody");
		$(".saibox").animate({left:"15%"});
		$(".sbody>div.container>.qmain").animate({right:"40%"});
		}
function closesai(){
		$("body").removeClass("sbody");
		}	
			
</script>