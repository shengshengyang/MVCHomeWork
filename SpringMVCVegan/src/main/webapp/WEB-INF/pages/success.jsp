<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p align="center"> 刪除成功 </p>
<form action="list" method="GET">
<!-- <a href="list">回首頁</a> -->
 <p align="center"><a href="<c:url value='../list'/>">回首頁</a></p>
</form>
</body>
</html>