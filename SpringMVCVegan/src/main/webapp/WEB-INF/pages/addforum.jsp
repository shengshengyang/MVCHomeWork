<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:useBean id="now" class="java.util.Date"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add forum</title>
</head>
<body>
<h3>add forum</h3>
		<form action="add.controller" method="get" enctype="multipart/form-data">
				<p>title</p>
				<input type="text" name="forumTitle" /><br/>
				<p>Content</p>
				<input type="text" name="forumContent" /><br/>
				<p>最後發表時間<font size='-3' color='blue'>(yyyy-MM-dd
								)</font>：<br>&nbsp;</p>
				<input type="text" name="forumDate" value="" /><br/>
		
		<input type="submit" value="Send"/>
</form>
</body>
</html>