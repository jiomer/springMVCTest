<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="register" modelAttribute="user">
		<table>
			<tr>
				<td>姓名：</td>
				<td><form:input path="loginname"/></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><form:password path="password"/></td>
			</tr>
			<form:textarea path="username" rows="10" cols="10"/>
		</table>
	</form:form>
</body>
</html>