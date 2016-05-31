<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.3.js" ></script>
<style>
			#content{
				border: 1px solid red;
				width: 500px;
				height: 400px;
				position: relative;
			}
			.master{
				position: absolute;
				top: 0;
				left: 0;
				width: 100%;
				height: 100%;
			}
			#content2{
				display: none;
			}
		</style>
</head>
<body>
welcome you to login<br/><br/>
<a href="#" name="1" >文章管理</a>
	<a href="#"  name="2" >用户管理</a>
	<a href="#"  name="3" >资源管理</a>
	<a href="#"  name="4" >类别管理</a>
	<a href="#"  name="5" >评论管理</a>
	<br/>
	<div id="content">
		<div id="content1" class="master">
		<jsp:include page="./contentList.jsp" ></jsp:include>
		</div>
		<div id="content2" class="master">
			<jsp:include page="./userManage.jsp" ></jsp:include>
		</div>
		<div id="content3" class="master">
		<jsp:include page="./ResourseManage.jsp" ></jsp:include>
		</div>
		<div id="content4" class="master">
		<jsp:include page="./TypeManage.jsp" ></jsp:include>
		</div>
		<div id="content5" class="master">
		<jsp:include page="./Review.jsp" ></jsp:include>
		</div>
	</div>
		<script>
		   $("#content").css("display","none");
			$("a").click(function(){
				  $("#content").css("display","block");
				var value=$(this).attr("name");
				$("#content"+value).css("display","block").siblings().css("display","none");
			});
			
		</script>


</body>
</html>