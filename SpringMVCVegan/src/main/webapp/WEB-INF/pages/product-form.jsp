<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品表單</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">商品新增</h2>
   <div class="panel panel-info">
    <div class="panel-heading">
    </div>
    <div class="panel-body">
     <form:form action="saveProduct" cssClass="form-horizontal"
      method="post" modelAttribute="product">

      <!-- need to associate this data with product id -->
      <form:hidden path="productId" />

      <div class="form-group">
       <label for="firstname" class="col-md-3 control-label">商品名</label>
       <div class="col-md-9">
        <form:input path="productName" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="lastname" class="col-md-3 control-label">商品價格</label>
       <div class="col-md-9">
        <form:input path="productPrice" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <label for="email" class="col-md-3 control-label">商品圖片</label>
       <div class="col-md-9">
        <form:input path="productImage" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>