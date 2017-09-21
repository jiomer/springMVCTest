<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>文件上传</h2>
	<form action="upload" enctype="multipart/form-data" method="post">
		<label>
			<p>文件名</p>
			<input type="text" name="description">
		</label>
		<label>
			<p>请选择文件</p>
			<input type="file" name="file" value="上传">
		</label>
		<p></p>
		<input type="submit" value="提交">
	</form>
</body>
</html>