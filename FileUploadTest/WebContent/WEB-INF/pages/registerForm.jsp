<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>用户注册</h2>
	<form action="register" enctype="multipart/form-data" method="post">
		<label>
			<p>用户名</p>
			<input type="text" name="username">
		</label>
		<label>
			<p>请选择文件</p>
			<input type="file" name="image" value="上传">
		</label>
		<p></p>
		<input type="submit" value="提交">
	</form>
</body>
</html>