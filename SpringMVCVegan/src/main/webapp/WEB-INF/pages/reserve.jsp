<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserve</title>
<script type="text/javascript" src="<c:url value='/js/jquery-1.12.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/reserve.js'/>">> </script>
</head>
<body>
<div align = "center">
<h2>Reserve Ajax 查詢全部</h2>
<button id='clickReserve'>AJAX查詢最新列表</button>
<div id='reserve'></div>
</div>
<div align='center'>
<h3>新增訂位資料表單</h3>
<hr>
<div align="center" id='resultMsg' style="height: 18px; font-weight: bold;"></div>
	<br>
	<fieldset style='display: inline-block; width: 820px;'> 
	<legend>填寫下列資料</legend>
	<table border='1'>
	<tr height='60'>

		<td width='400'>
			&nbsp;訂位編號: <input type="text" name="reserveId" id='reserveId' placeholder="輸入Id可執行單一查詢"><br>
		</td>
		<td width='200' style="vertical-align:top">
			<div id='result0c' style="height: 10px;"></div>
		</td>	
	</tr>
	<tr height='60'>

		<td width='400'>
			&nbsp;訂位姓名: <input type="text" name="reserveName" id='reserveName'><br>
		</td>
		<td width='200' style="vertical-align:top">
			<div id='result1c' style="height: 10px;"></div><br>
			<div id='result1s' style="height: 10px;"></div>
		</td>	
	</tr>
	<tr height='60'>

		<td width='400'>
			&nbsp;日期: <input type="date" name="reserveDate" id='reserveDate'><br>
		</td>
		<td width='200' style="vertical-align:top">
			<div id='result2c' style="height: 10px;"></div><br>
			<div id='result2s' style="height: 10px;"></div>
		</td>	
	</tr>
	<tr height='60'>		

		<td width='400'>
			&nbsp;餐廳名稱: <input type="text" name="reserveRestuarant" id='reserveRestuarant' size='24'>
		</td>	
		<td width='200'>
			<div id='result3c' style="height: 10px;"></div><br>
			<div id='result3s' style="height: 10px;"></div>			
		</td>	
	</tr>
	<tr height='50'>		
		<td colspan='' align='center'><button id='sendData'>新增資料</button>
		<button onclick="makePUTrequest()">修改</button>
		<button onclick="makeDELETErequest()">刪除</button>
		</td>
		<td colspan='' align='center'><button onclick="searchGETrequest()">執行單一查詢方法</button></td>
	</tr>	
	</table>
	</fieldset>
	<hr>	
	<p>	
	<div align="center">  <a href="<c:url value='/index'  />">回前頁</a></div>
<hr>
</div>
</body>
</html>