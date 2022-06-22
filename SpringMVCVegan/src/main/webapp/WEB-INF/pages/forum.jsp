<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forum</title>

</head>
<body>
	<h2 align="center">Forum</h2>

	<form action="list" method="GET">
		<table align="center" border="1">
			<tr>
				<th width='60'>標題</th>
				<th width='160'>留言</th>
				<th width='160'>日期</th>
			</tr>

			<c:forEach var='forums' items="${forums}">

				<tr>
					<td align='center'><c:out value="${forums.forumTitle}" /></td>
					<td align='center'><c:out value="${forums.forumContent}" /></td>
					<td align='center'><c:out value="${forums.forumDate}" /></td>
					<%--<td><a href="<c:url value='/edit/${forums.forumid}'></c:url>">更新留言</a></td> --%>
					<td><a href="<c:url value="list/${forums.forumid}"></c:url>">刪除留言</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<p align="center"><a href="<c:url value="/insert"></c:url>" >新增留言</a></p>
</body>
</html>