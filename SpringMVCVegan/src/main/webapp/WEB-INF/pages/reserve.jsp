<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserve</title>
</head>
<body>
	<h3>訂位頁面</h3>
	<form:form action="addReserve" method="post" modelAttribute="Reserve">
		<table>
			<tr>
				<td><form:label path="reserveName">訂位大名: </form:label></td>
				<td><form:input path="reserveName"/></td>
			</tr>
			<tr>
				<td><form:label path="reserveDate">訂位日期: </form:label></td>
				<td><form:input path="reserveDate"/></td>
			</tr>
			<tr>
				<td><form:label path="reserveRestuarant">訂位餐廳:</form:label></td>
				<td><form:input path="reserveRestuarant"/></td>
			</tr>
			<tr>
				<td colspan="2"><form:button value="send">送出</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>