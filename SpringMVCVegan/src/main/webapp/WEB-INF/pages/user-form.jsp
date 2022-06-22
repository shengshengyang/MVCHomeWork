<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.error{color:red}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
</head>
<body>
<div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">新增或修改User</h2>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">新增或修改一筆資料</div>
    </div>
    <div class="panel-body">
     <form:form action="saveUser" cssClass="form-horizontal"
      method="post" modelAttribute="user">

      <!-- need to associate this data with customer id -->
      <form:hidden path="uid" />

      <div class="form-group">
       <label for="email" class="col-md-3 control-label">Email</label>
       <div class="col-md-9">
        <form:input path="email" cssClass="form-control" />
        <form:errors path="email" cssClass="error" />
       </div>
      </div>
      <div class="form-group">
       <label for="password" class="col-md-3 control-label">Password</label>
       <div class="col-md-9">
        <form:input path="password" cssClass="form-control" />
        <form:errors path="password" cssClass="error" />
       </div>
      </div>

      <div class="form-group">
       <label for="username" class="col-md-3 control-label">Username</label>
       <div class="col-md-9">
        <form:input path="username" cssClass="form-control" />
        <form:errors path="username" cssClass="error" />
       </div>
      </div>

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">送出</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>