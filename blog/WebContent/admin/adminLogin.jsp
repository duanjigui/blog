<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body>
<%=request.getAttribute("tip")==null?"":request.getAttribute("tip") %>
	<form action="./LoginService" method="post">
		账号：<input type="text"  name="account"  value="<%=request.getAttribute("adminAccount")==null?"":request.getAttribute("adminAccount") %>" /><br/>
		密码：<input type="password"  name="password"><br/>
		验证码：<input type="text"  name="verfiyCode">  
		<br/><input type="submit" value="登录">
		<input type="reset"  value="重置">
	</form>
	<img src="VerfiyCodeService" width="90px" height="70px" />
</body>
</html>