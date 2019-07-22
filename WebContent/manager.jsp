<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>U+定制旅游后台管理</title>
<meta charset="utf-8">
<!-- boostrap需要的所有的css -->
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<!-- 主题CSS -->
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
<!-- bootstrap需要jquery作为基础 -->
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<!-- boostrap需要的js -->
<script type="text/javascript"
	src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="roow">
			<div class="col-md-12 ">
				<div class=" panel-default">
					<h1>U+定制旅游后台管理</h1>
				</div>
			</div>
		</div>
		<div class="roow">
			<!-- 菜单部分 -->
			<div class="col-md-2 ">
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne"> 预约单管理 </a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<ul class="list-group">
									<li class="list-group-item"><a  target="content" href="appointList.jsp">预约单列表</a></li>
								</ul>
							</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo"
									aria-expanded="false" aria-controls="collapseTwo"> 用户管理 </a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingTwo">
							<div class="panel-body">
								<ul class="list-group">
									<li class="list-group-item"><a target="content"	href="userList.jsp">用户列表</a>

</ul>
							</div>
						</div>
					</div>
					
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading3">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapse3"
									aria-expanded="false" aria-controls="collapse3"> 商品管理 </a>
							</h4>
						</div>
						<div id="collapse3" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading3">
							<div class="panel-body">
								<ul class="list-group">
									<li class="list-group-item"><a target="content"
										href="tripList.jsp">商品列表</a></li>
									<li class="list-group-item"><a target="content" href="addTrip.jsp">添加商品</a></li>
								</ul>
							</div>
						</div>
					</div>
					
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading4">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapse4"
									aria-expanded="false" aria-controls="collapse4"> 旅游主题管理</a>
							</h4>
						</div>
						<div id="collapse4" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading4">
							<div class="panel-body">
								<ul class="list-group">
									<li class="list-group-item"><a target="content"
										href="menuList.jsp">主题列表</a></li>
									<li class="list-group-item">
									<a target="content" href="addMenu.jsp">添加主题</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading5">
							<h4 class="panel-title">
								<a class="collapsed5" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapse5"
									aria-expanded="false" aria-controls="collapse5"> 订单管理 </a>
							</h4>
						</div>
						<div id="collapse5" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading5">
							<div class="panel-body">
								<ul class="list-group">
									<li class="list-group-item"><a target="content"
										href="orderList.jsp">订单管理</a></li>
									<li class="list-group-item"><a target="content" href="addOrder.jsp">添加订单</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 主面板 -->
			<div class="col-md-10 "
				style="border: 0px; height: 600px; overflow: hidden;">
				<iframe name="content" style="overflow: hidden;" src="welcome.html"
					width="100%" height="100%" frameborder="0"></iframe>
			</div>
		</div>
	</div>
</body>
</html>