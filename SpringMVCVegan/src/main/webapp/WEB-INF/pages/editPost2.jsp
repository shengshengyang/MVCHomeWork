<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>編輯文章</title>
<style>
* {
	margin: 0;
	padding: 0;
}

body, html {
	width: 100%;
	height: 100%;
}

.textbody {
	background-color: #f6f8fc;
	text-align: center;
}

.title {
	padding: 20px
}

.text_title {
	resize: none;
	width: 60%;
}

.text_area {
	resize: none;
	width: 60%;
}

.text {
	padding: 10px;
}

#wordsNum1 {
	text-align: right;
	width: 80%;
}

#wordsNum2 {
	text-align: right;
	width: 80%;
}

.wordsNum2 {
	width: 80%;
	position: relative;
	text-align: right;
}
</style>
</head>

<body>
	<div class="textbody">
		<div class="title">
			<h3>編輯文章</h3>
			<hr>
		</div>

		<form:form  enctype="multipart/form-data" method="POST" modelAttribute="posts" >
		
		上傳圖片：<form:input type="file" path="postImage"/>
			<hr>
			<h5 class="text">文章標題:</h5>
			<form:textarea  path="title" class="text_title" rows="1" maxlength="100"
				/>
			<p id="wordsNum1">
				<span class="wordsNum1">0</span>/<span>100</span>
			</p>
			<h5 class="text">文章內容:</h5>
			<form:textarea  path="postedText" class="text_area"  rows="20" maxlength="5000"/>
			<p id="wordsNum2">
				<span class="wordsNum2">0</span>/<span>5000</span>
			</p>
			<input type="submit" value="更新文章" id="yesno"/> 
		</form:form>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
	<script>
		$(function() {
			/*input字數*/
			/*在頁面剛載入時先顯示出輸入框的字數*/
			var text1 = $(".text_title").val();
			var counter1 = text1.length;
			$(".wordsNum1").text(counter1);
			/*新增觸發事件進行動態計算輸入框的字數*/
			$(".text_title").on('blur keyup input', function() {
				var text = $(".text_title").val();
				var counter = text.length;
				$(".wordsNum1").text(counter);
			});
			/* textarea字數*/
			var text2 = $(".text_area").val();
			var counter2 = text2.length;
			$(".wordsNum2").text(counter2);
			$(".text_area").on('blur keyup input', function() {
				var text = $(".text_area").val();
				var counter = text.length;
				$(".wordsNum2").text(counter);
			});
			
			$('#yesno').click(function(event) {
		        if(($.confirm({
		          title: '',
		          animation: 'zoom',
		          closeAnimation: 'scale',
		          content: '請問是否確定送出？',
		          buttons: {
		            是: function() {
		                $('#posts').submit();
		            },
		            否: function() {
		               
		            }
		          }
		        }))){
		        event.preventDefault();
		      }
		      });
		})
	</script>
</body>
</html>