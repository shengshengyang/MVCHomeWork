<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vegan Index</title>
<script type="text/javascript" src="<c:url value='/js/jquery-1.12.2.min.js'/>"></script>

</head>
<body>
<table>
    <thead>
        <tr>
            <th colspan="2">這是第一組的作業</th>
        </tr>
        <tr>
            <th colspan="2">${login.status}</th>
        </tr>
    </thead>
    <tbody>
    	<c:choose>
    		<c:when test="${not empty userLoginInfo}">
        		<tr>
            		<td><a href="<c:url value='/logout' />">${username}點我登出          </a></td>
        		</tr>
        	</c:when>
    		<c:otherwise>
        		<tr>
            		<td><a href="<c:url value='/user/goLogin' />">點我登入        </a></td>
        		</tr>
<!--         		<tr> -->
<%--             		<td><a href="<c:url value='/user/showForm' />">點我註冊          </a></td> --%>
<!--         		</tr> -->
        	</c:otherwise>
    	</c:choose>
        <tr>
            <td><a href="product/list">組長: CRUD : 購物車</a></td>
        </tr>
        <tr>
            <td><a href="restaurant/restaurants">組員A : CRUD : 餐廳</a></td>
        </tr>
        <tr>
            <td><a href="posts/postIndex">組員B : CRUD : 食記</a></td>
        </tr>
        <tr>
            <td><a href="<c:url value='/user/list' />">組員C : CRUD : 會員</a></td>
        </tr>
        <tr>
			<td><a href="list">組員D : CRUD : 網誌</a></td>
		</tr>
        <tr>
            <td><a href="reserve.controller">組員E : CRUD : 訂單</a></td>

        </tr>
    </tbody>
</table>
</body>
</html>