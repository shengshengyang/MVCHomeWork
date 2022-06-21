<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:useBean id="now" class="java.util.Date"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add forum</title>

</head>
<body>
<h3>add forum</h3>
<%-- 		<form:form action="edit/{id}" modelAttribute="forum" method="get"> --%>
<!-- 			<p>forumTitle</p> -->
<%-- 			<form:input path="forumTitle"/> --%>
<!-- 			<p>forumContent</p> -->
<%-- 			<form:input path="forumContent"/> --%>
<!-- 			<p>forumDate</p> -->
<%-- 			<form:input path="forumDate"/> --%>
			
<%-- 			<input type='submit' value='修改' name='updateBtn' onclick="return confirmUpdate('${forum.id}');"> --%>
<%-- 		</form:form> --%>
		
		<form action="edit/{id}" method="GET">
		<input type="text" name="forumTitle"/><br/>
		
		<input type="text" name="forumContent"/><br/>
		
		<input type="text" name="forumDate"/><br/>
		<input type="submit" name="edit" value="Send"/>		
		</form>
</body>
</html>