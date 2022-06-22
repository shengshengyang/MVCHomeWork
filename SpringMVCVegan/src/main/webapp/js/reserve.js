$(document).ready(
 function() {
  
 $('#clickReserve').click(
  function() {
      $.getJSON("/SpringMVCVegan/getReserves",
    function(categoriesJson) {  
    $("#reserve").empty();
    var $table = $('<table border="1">')
     .appendTo($('#reserve'))
     .append("<tr><th>編號</th><th>訂位大名</th><th>訂位日期</th><th>餐廳名稱</th></tr>");
    $("#reserve").append($table)
         $.each(categoriesJson,
               function(index, element) {
      $('<tr>').appendTo($table)
      .append($('<td align="center">').text(element.reserveId))
      .append($('<td>').text(element.reserveName))
      .append($('<td>').text(element.reserveDate))
      .append($('<td align="right">').text(element.reserveRestuarant))
   });
  });
 });
   var sendData = document.getElementById("sendData");
   sendData.onclick = function() {
		hasError = false;
  		// 讀取欄位資料	  
		var nameValue = document.getElementById("reserveName").value;
		var dateValue = document.getElementById("reserveDate").value;
		var restuarantNameValue = document.getElementById("reserveRestuarant").value;
		var div1 = document.getElementById('result1c');
		var div2 = document.getElementById('result2c');
		var div3 = document.getElementById('result3c');
		var divResult = document.getElementById('resultMsg');
		if (!nameValue){
			setErrorFor(div1, "請輸入訂位大名");
		} else {
			div1.innerHTML = "";
		}
   		if (!dateValue){
			setErrorFor(div2, "請輸入訂位日期");  
   		} else if(!dateValidation(dateValue)) {
			setErrorFor(div2, "訂位日期格式錯誤，正確格式為yyyy/MM/dd");
   		} else {
   			div2.innerHTML = "";
   		}
		if (!restuarantNameValue){
			setErrorFor(div3, "請輸入餐廳名稱");
		} else {
			div3.innerHTML = "";
		}
   		if (hasError){
       		return false;
   		}
   		var xhr1 = new XMLHttpRequest();
   		xhr1.open("POST", "/SpringMVCVegan/addReserve", true);
		var jsonReserve = {
			"reserveName": nameValue,
			"reserveDate": dateValue,
			"reserveRestuarant": restuarantNameValue
   		}
  		xhr1.setRequestHeader("Content-Type", "application/json");
  		xhr1.send(JSON.stringify(jsonReserve));
  		xhr1.onreadystatechange = function() {
			// 伺服器請求完成
		if (xhr1.readyState == 4 && (xhr1.status == 200 || xhr1.status == 201) ) {
  		result = JSON.parse(xhr1.responseText);
  		if (result.fail) {
	 		divResult.innerHTML = "<font color='red' >"
				+ result.fail + "</font>";
  		} else if (result.success) {
			divResult.innerHTML = "<font color='GREEN'>"
				+ result.success + "</font>";
			div1.innerHTML = "";
			div2.innerHTML = "";
			div3.innerHTML = "";
 		} else {
			if (result.nameError) {
      			div1.innerHTML = "<font color='green' size='-2'>"
					+ result.nameError + "</font>";
			} else {
      			div1.innerHTML = "";
   			}
			if (result.dateValue) {
      			div2.innerHTML = "<font color='green' size='-2'>"
					+ result.dateError + "</font>";
			} else {
      			div2.innerHTML = "";
			}
			if (result.restuarantNameValue) {
    			div3.innerHTML = "<font color='green' size='-2'>"
					+ result.restuarantError + "</font>";
			} else {
      			div3.innerHTML = "";
			}
 		}};
  		}};
function setErrorFor(input, message){
	input.innerHTML = "<font color='red' size='-2'>" + message + "</font>";
    hasError = true;
};
function dateValidation(str) {
	  var re = new RegExp("^([0-9]{4})[.-]{1}([0-9]{1,2})[.-]{1}([0-9]{1,2})$");
	  var days = [0, 31, 28, 31, 30,  31, 30, 31, 31, 30, 31, 30, 31];
	  var strDataValue;
	  var valid = true;
	  if ((strDataValue = re.exec(str)) != null) {
	    var y, m, d;
	    y = parseFloat(strDataValue[1]);
	    if (y <= 0 || y > 9999) { /*年*/
	      return false;
	    } 
	    m = parseFloat(strDataValue[2]);
	    
	    if (m < 1 || m > 12) { /*月*/
	        return false;
	    }
	    d = parseFloat(strDataValue[3]);
	    if ( y % 4 == 0 && y % 100 != 0 || y % 400 == 0 ){
	       days[2] = 29;
	    }  else {
	       days[2] = 28;
	    }
	    if (d <= 0 || d > days[m]) { /*日*/
	      valid = false;
	    }
	  } else {
	    valid = false;
	  }  
	  return valid;
	};
 });