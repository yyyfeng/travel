<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑行程</title>
<link href="easyui/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="easyui/themes/icon.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="utf8-jsp/ueditor.all.min.js"></script>
</head>
<body>
	<form id="ff">
		<input type="hidden" name="tripId" value="" id='tripId'>
		<input type="hidden" name="tripImg" id="tripImg" >
		<div>
			行程名称:<input id="tripName" type="text" name="tripName"
				placeholder="行程名称">
		</div>
		<div>
			行程概述:<input id="tripDesc" type="text" name="tripDesc"
				placeholder="行程概述">
		</div>
		<div>
			行程费用:<input id="tripCost" type="text" name="tripCost"
				placeholder="行程费用">
		</div>
		<div>
			行程天数:<input id="tripDays" type="text" name="tripDays"
				placeholder="行程天数">
		</div>
		<div>
			目的地点:<input id="tripDest" type="text" name="tripDest"
				placeholder="目的地点">
		</div>
		<div>
			主题编号:<input id="tripMenu" type="text" name="reserveNote"
				placeholder="主题编号">
		</div>

		<div>
			主题图片:<span id="span"></span><input onclick="uploadImg()" value="上传图片"
				type="button">
				<script name="tripImgUe" style="width: 1024px; height: 500px;"
			type="text/plain" id="tripImgUe"></script>
		</div>
		<div>
			<label for="originalPrice">专属体验:</label>
				<script name="experience" style="width: 1024px; height: 500px;"
			type="text/plain" id="experience"></script>
		</div>
		<div>
			<label for="originalPrice">推荐酒店:</label>
				<script name="tripHotel" style="width: 1024px; height: 500px;"
			type="text/plain" id="tripHotel"></script>
		</div>
		
		<div>
			<label for="originalPrice">费用包含:</label>
				<script name="costInclude" style="width: 1024px; height: 500px;"
			type="text/plain" id="costInclude"></script>
		</div>
		<div>
			<label for="originalPrice">费用不含:</label>
				<script name="costUnInclude" style="width: 1024px; height: 500px;"
			type="text/plain" id="costUnInclude"></script>
		</div>
		<div>
			<label for="originalPrice">预订须知:</label>
				<script name="reserveNote" style="width: 1024px; height: 500px;"
			type="text/plain" id="reserveNote"></script>
		</div>
		<div class='field'>
			<label for="originalPrice">行程详情:</label>
			<script name="tripDetail" style="width: 1024px; height: 500px;"
				type="text/plain" id="tripDetail">
			
			</script>
		</div>
		<div>
			<input type="button" onclick="sub()" value="提交">
		</div>

	</form>
	<script type="text/javascript">
		
		//图片上传
		var imgue = UE.getEditor('tripImgUe');
		function uploadImg(){
			  var image = imgue.getDialog("insertimage");
			  image.open();
		  }
		imgue.ready(function(){
			  imgue.hide();
			  imgue.addListener("afterInsertImage",function(t,arg){
				  src = arg[0].src;
				  $("#span").html("<img  src='/travel/"+src+"' width='50' height='50'/>");
				  $("#tripImg").val(src);
				  console.log($("#tripImg").val());
			  })
		  })
		  
		function setmessage(id,cont){
			UE.getEditor(id).setContent(cont);
		}
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('tripDetail');
		var experience = UE.getEditor('experience');
		var tripHotel = UE.getEditor('tripHotel');
		var costInclude = UE.getEditor('costInclude');
		var costUnInclude = UE.getEditor('costUnInclude');
		var reserveNote = UE.getEditor('reserveNote');
		function sub() {
			var tripImg = $("#tripImg").val();//记录图片路径
			console.log(tripImg);
			//定义参数获取表单中的值
			var tripId= $("#tripId").val();
			var tripName = $("#tripName").val();
			var tripDesc = $("#tripDesc").val();
			var tripDest = $("#tripDest").val();
			var tripDays = $("#tripDays").val();
			var experience = UE.getEditor('experience').getContent();
			var tripHotel = UE.getEditor('tripHotel').getContent();
			var tripCost = $("#tripCost").val();
			var costInclude = UE.getEditor('costInclude').getContent();
			var costUnInclude = UE.getEditor('costUnInclude').getContent();
			var reserveNote = UE.getEditor('reserveNote').getContent();
			//var tripImg=null;
			
			var tripMenu = $("#tripMenu").val();
			var tripDetailContent = UE.getEditor('tripDetail').getContent();

			$.ajax({
				type : "GET",
				url : "trip?op=edit",
				data : {
					tripId:tripId,
					tripName : tripName,
					tripDesc : tripDesc,
					tripDest : tripDest,
					tripDays : tripDays,
					experience : experience,
					tripHotel : tripHotel,
					tripCost : tripCost,
					costInclude : costInclude,
					costUnInclude : costUnInclude,
					reserveNote : reserveNote,
					tripImg : tripImg,
					tripMenu : tripMenu,
					tripDetail : tripDetailContent
				},
				dataType : "json",
				success : function(data) {
					console.log(data);
					if (data == "1") {
						window.parent.closeWin();
					} else {
						alert("编辑失败");
					}
				}
			})
		}
	</script>
</body>
</html>