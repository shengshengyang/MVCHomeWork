<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta charset="UTF-8">
<title>商品區</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>商品列表</h2>
			<hr />

			<input type="button" value="新增商品" 
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br /> <br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">商品列表</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>商品名</th>
							<th>價格</th>
							<th>圖片</th>
							<th>變更</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="products" items="${products}">

							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/product/updateForm">
								<c:param name="productId" value="${products.productId}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/product/delete">
								<c:param name="productId" value="${products.productId}" />
							</c:url>

							<tr>
								<td>${products.productName}</td>
								<td>${products.productPrice}</td>
								<td>${products.productImage}</td>

								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
</body>
</html>