<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
</head>
<body>
<div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>User Table CRUD</h2>
   <hr />

   <input type="button" value="新增 User"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">User列表</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Email</th>
       <th>Password</th>
       <th>Username</th>
       <th>操作</th>
      </tr>

      
      <c:forEach var="tempUser" items="${users}">

       <c:url var="updateLink" value="/user/updateForm">
        <c:param name="userId" value="${tempUser.uid}" />
       </c:url>

       <c:url var="deleteLink" value="/user/delete">
        <c:param name="userId" value="${tempUser.uid}" />
       </c:url>

       <tr>
        <td>${tempUser.email}</td>
        <td>${tempUser.password}</td>
        <td>${tempUser.username}</td>

        <td>
          <a href="${updateLink}">修改</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('確定要刪除此使用者嗎?'))) return false">刪除</a>
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