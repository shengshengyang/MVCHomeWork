<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>後臺餐廳管理</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<style>
    h2{
        text-align: center;
    }
    body{
        background-color: lightblue;
    }
    div{
    	text-align: center;
    }
    fieldset{
    width:30%;
    border: 2px solid black;
    border-radius: 10px;
    margin: 20px auto;
    }
   
</style>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>餐廳列表</h2>
			<hr />

			<input type="button" value="新增餐廳"
				onclick="window.location.href='showForm'; return false;"
				 /> <br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading"> </div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>餐廳編號</th>
							<th>餐廳名稱</th>
							<th>餐廳電話</th>
							<th>餐廳地址</th>
							<th>餐廳類型</th>
							<th>素食種類</th>
							<th>營業時間</th>
							<th>評分</th>
							<th>資料維護</th>
						</tr>

					<!-- loop over and print our restaurant -->	
						<c:forEach var="restaurants" items="${restaurants}">

							<!-- construct an "update" link with restaurantNumber -->
							<c:url var="updateLink" value="/restaurant/updateRestaurant">
								<c:param name="restaurantNumber" value="${restaurants.restaurantNumber}" />
							</c:url>

<!-- 							construct an "delete" link with restaurantNumber -->
							<c:url var="deleteLink" value="/restaurant/delete">
								<c:param name="restaurantNumber" value="${restaurants.restaurantNumber}" />
							</c:url>
							
							<tr>
								<td><c:out value="${restaurants.restaurantNumber}"/></td>
								<td><c:out value="${restaurants.restaurantName}"/></td>
								<td><c:out value="${restaurants.restaurantTel}"/></td>
								<td><c:out value="${restaurants.restaurantAddress}"/></td>
								<td><c:out value="${restaurants.restaurantCategory}"/></td>
								<td><c:out value="${restaurants.restaurantType}"/></td>
								<td><c:out value="${restaurants.restaurantBusinessHours}"/></td>
								<td><c:out value="${restaurants.restaurantScore}"/></td>

								<td>
									<!-- display the update link --> 
									<a href="${updateLink}">修改</a>
									 <a href="${deleteLink}" onclick="if (!(confirm('確定要刪除此筆資料嗎?'))) return false">刪除</a>
								</td>

							</tr>

						</c:forEach>

					</table>
							<a href=<c:url value="/index"/> > <input type ="button" value="回首頁"></input></a>
								
				</div>
			</div>
		</div>

	</div>
</body>
</html>