<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSystem</title>
</head>
<body>
<h3>LoginSystem</h3>
<form action="<%=request.getContextPath()%>/user/login" method="post">
	<table>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email"/></td>
			<td>${errors.name}</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"/></td>
			<td>${errors.pwd}</td>		
		</tr>
		<tr>
			<td><button type="submit" value="login">Login</button></td>
			<td><input type="button" value="回到首頁"
    onclick="window.location.href='http://localhost:8080/SpringMVCVegan/index';"/></td>
			<td>${errors.msg}</td>		
		</tr>
	</table>
</form>
</body>
</html>