<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UploadService"  method="post"  enctype="Multipart/form-data">
账号：<input type="text"   name="account" /><br/>
密码：<input type="text"   name="account" /><br/>
上传文件<input type="file"   name="file"/><br/>
<input type="submit"   value="上传"/>
</form>
</body>
</html>