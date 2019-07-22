<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<base href="${pageContext.request.contextPath }/front/" />
<title>行程详情</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0, user-scalable=no, width=device-width"
	name="viewport" />
<meta name="author" content="" />
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/detail.js"></script>
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->

</head>
<body class="detail">
	<div class="otop">
		<div class="container">
			<div class="row">
				<div class="col-xs-2 pdrnone">
					<a href="../trip?op=detaillist&menuId=${trip.tripMenu }"><img src="images/ico/ico_back.png"
						width="35" alt=""></a>
				</div>
				<div class="col-xs-10">${trip.tripDesc}</div>
			</div>
		</div>
	</div>
	<!--//.otop-->
	<div class="container">
		<div class="p_tuijian">
			<div class="tj_img">
				<img style="width: 100%; height: 322;" src="${trip.tripImg }" alt="">
			</div>
			<!--//.tj_img-->
			<div class="tj_box">
				<div class="tj_tag"></div>
				<!--//.tj_tag-->
				<div class="tj_tll">
					<i class="iconfont2">&#xe60d;</i>产品推荐详情 </br>
					</br> <i>${trip.tripName }</i>
				</div>
				<!--//.tj_tll-->
				<div class="tj_info"></div>
				<!--//.tj_info-->
			</div>
			<!--//.tj_box-->
		</div>
		<!--//.p_tuijian-->
		<div class="fixmain" id="fix1">
			<div class="fixnav">
				<ul>
					<li class="cur">专属体验</li>
					<li>详细行程</li>
					<li>推荐酒店</li>
				</ul>
			</div>
			<!--//.fixnav-->
			<div class="fx"></div>
			<div class="fixbox">
				<div class="fixlist">
					<!--//.fixfoc-->
					<div class="fixcon">
						${trip.experience }
						<p class="sx"></p>
					</div>
					<!--//.fixcon-->
				</div>
				<!--//.fixlist-->
				<div class="fixlist">
				${trip.tripDetail }
					<!--//.xqcon-->
				</div>
				<!--//.fixlist-->
				<div class="fixlist">
					<div class="xqcon">${trip.tripHotel }</div>
					<!--//.xqcon-->
				</div>
				<!--//.fixlist-->
			</div>
			<!--//.fixbox-->
		</div>
		<!--//.fixmain-->
		<div class="fixmain" id="fix2">
			<div class="fixnav">
				<ul>
					<li class="cur">费用包含</li>
					<li>费用不含</li>
					<li>预定须知</li>
				</ul>
			</div>
			<!--//.fixnav-->
			<div class="fx"></div>
			<div class="fixbox">
				<div class="fixlist">
					<div class="fixcon"><p style="color: red;">费用总额：${trip.tripCost }/人</p></div>
					<div class="fixcon">${trip.costInclude }</div>
					<!--//.fixcon-->

				</div>
				<!--//.fixlist-->
				<div class="fixlist">
					${trip.costUnInclude }
					<!-- 
					<p>
						<i class="iconfont2">&#xe623;</i>【机票】国际段机票及机场燃油税（经济舱）
					</p>
					<p>
						<i class="iconfont2">&#xe623;</i>【餐饮】为了您的行程舒适，餐不含（导游推荐用餐）；
					</p>
					<p>
						<i class="iconfont2">&#xe623;</i>【自行安排行程】行程表上未表明记载的各项开支,自选自费行程及应付费用；
					</p>
					<p>
						<i class="iconfont2">&#xe623;</i>【私人消费】如行程标示外的饮料酒类、洗衣电话、网路及行程外私人交通费；
					</p>
					<p>
						<i class="iconfont2">&#xe623;</i>【发票税点】如需开具发票,请另付 3%税点；
					</p>
					<p>
						<i class="iconfont2">&#xe623;</i>【其他费用】因交通延误、战争、政变、罢工、自然灾害、飞机故障、航班取消或更改时间等不可抗力原因所致的额外费用。
					</p>
					 -->
				</div>
				<!--//.fixlist-->
				<div class="fixlist">
					${trip.reserveNote }
					<!--  
					<p>起价说明</p>
					<p></p>
					<p>本起价是按双人出行共住一间房核算的最低单人价格。产品价格会根据您所选择的出发日期出行人数、入住酒店房型、航班或交通以及所选附加服务的不同而有所差别。</p>
					<p></p>
					<p></p>
					<p>1、本产品价格为参考价格，最终价格将根据您的出发日期、出行人数、入住酒店、航班及交通、附加服务等要素最终确定。</p>
					<p>2、当与您的旅游顾问确定预订信息时，请再次核实您提交的出行人信息、出发返回日期、航班、酒店房型等要求是否准确，以便为您更快、更准确获得预订确认。</p>
					<p>3、预订时，我们建议你再次确认你的证件有效期大于6个月。</p>
					<p>4、在旅游顾问向您提供该笔订单即时报价后，如达成购买意向，您需预先支付一笔定金，您的旅游顾问将在第一时间为您锁定优质资源。</p>
					<p>5、预订成功后，您的旅行顾问将在24小时内向您发送预订确认书，并通知您支付尾款。在收到确认书后请您仔细检查预订信息是否正确，并在约定时间内支付尾款。如您未在约定时间内付清尾款，订单自动取消。</p>
					<p>6、支付尾款前，您可与您的旅行顾问确认预订“免费”取消期限。若您遇到在不可取消期限内不得不取消情况，我们将尽可能为您做协调或延迟出行日期，并尽最大可能降低您的损失。</p>
					<p>7、我们的度假产品，均不含3%的增值税发票，如需发票请另行支付发票税费。</p>
					<p></p>
					<p></p>
					<p></p>
					<p>【以下情形需要您务必留意】</p>
					<p>1、因您提供的材料存在问题或因您自身其他原因被拒签、缓签、拒绝入境和出境的，相关责任和产生的费用均由您本人承担。</p>
					<p>2、为了不耽误您的行程，请您在国际航班起飞前180分钟到达机场办理登机以及出入境相关手续；如涉及海外国内段行程，请您在航班起飞前60分钟到达机场办理登机手续。因个人原因造成的误机所造成的损失本司不予承担。</p>
					<p>3、因气候、管控、战争、政变、罢工、国家政策调整等不可抗力或飞机、车辆、船只等交通工具发生故障导致既定行程出现变更或无法成行，由此引发的损失游加旅行不承担任何责任。</p>
					<p>4、为了您的安全起见，当您参加有一定危险性的室内或户外活动时，请务必了解当天的天气及您个人身体状况是否适合，如不适合参加，建议您取消此活动安排。</p>
					-->
				</div>
				<!--//.fixlist-->
			</div>
			<!--//.fixbox-->
		</div>
		<!--//.fixmain-->
	</div>
	<div class="dfoot">
		<div class="col-xs-2 txl" id="getshare">
			<a href="javascript::"><i class="iconfont2">&#xe7e0;</i></a>
		</div>
		<div class="col-xs-2 txc" id="gettel">
			<a href="javascript::"><i class="iconfont2">&#xe64f;</i></a>
		</div>
		<div class="col-xs-2 txc" id="getwx">
			<a href="javascript::"><i class="iconfont2">&#xe64e;</i></a>
		</div>
		<div class="col-xs-2 txc bdsharebuttonbox" id="getwx1">
			<a class="bds_weixin" data-cmd="weixin"></a>
		</div>
		<div class="col-xs-2 txc bdsharebuttonbox" id="getpyq">
			<a class="bds_weixin bds_pyq" data-cmd="weixin"></a>
		</div>
		<div class="col-xs-2 txc bdsharebuttonbox" id="getsina">
			<a class="bds_tsina" data-cmd="tsina"></a>
		</div>
		<div class="col-xs-4 txr fr">
			<form action="../order?op=inputOrder&tripId=${trip.tripId }" method="POST">
				<input type="submit" value="立即预定" class="sub_yuding">
			</form>
		</div>
	</div>
	<!--//.dfoot-->
	<div class="dtelmain" id="dtelbox">
		<div class="dteltop">400-705-1815</div>
		<div class="dtelbot dbotbtn">
			<li><a class="dclose">取消</a></li>
			<li><a href="tel:4007051815">拨打</a></li>
		</div>
	</div>
	<div class="dtelmain" id="dwxbox">
		<div class="dteltop">
			<img src="images/ico/ico_wx.png" alt="">
		</div>
		<div class="dtelbot" style="padding-top: 18px;">
			请关注微信号<a href="#">游加旅行</a><br>享受旅行顾问一对一专属服务
		</div>
	</div>
	<div class="imark"></div>
	<div class="gettop">
		<img src="images/ico/ico_top.png">
	</div>
</body>
</html>

<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"16"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>