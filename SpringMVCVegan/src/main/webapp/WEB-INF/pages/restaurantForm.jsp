<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>餐廳表單</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">新增/修改餐廳</h2>
			<div class="panel panel-info">
				<div class="panel-heading"></div>
				<div class="panel-body">
					<form:form action="saveRestaurant" cssClass="form-horizontal"
						method="post" modelAttribute="restaurant"
						enctype='multipart/form-data'>

						<!-- need to associate this data with product id -->
						<form:hidden path="restaurantNumber" />

						<div class="form-group">
							<label>餐廳名稱</label>
							<div class="col-md-9">
								<form:input path="restaurantName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label>餐廳電話</label>
							<div class="col-md-9">
								<form:input path="restaurantTel" cssClass="form-control" />
							</div>
						</div>
							<div class="form-group">
							<label>餐廳地址</label>
							<div class="col-md-9">
								<form:input path="restaurantAddress" cssClass="form-control" />
							</div>
						</div>
							<div class="form-group">
							<label>評分</label>
							<div class="col-md-9">
								<form:input path="restaurantScore" cssClass="form-control" />
							</div>
						</div>
							<div class="form-group">
							<label>餐廳類型</label>
							<div class="col-md-9">
								<form:input path="restaurantCategory" cssClass="form-control" />
							</div>
						</div>
							<div class="form-group">
							<label>素食種類</label>
							<div class="col-md-9">
								<form:input path="restaurantType" cssClass="form-control" />
							</div>
						</div>
							<div class="form-group">
							<label>營業時間</label>
							<div class="col-md-9">
								<form:input path="restaurantBusinessHours" cssClass="form-control" />
							</div>

						<br>
						
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">送出</form:button>
							</div>
						</div>
						
						<br>

					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>