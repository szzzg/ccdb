<!--
@author: 周志刚
@phone：15295621977
@E-mail：szzzg@126.com
@Description: 
@create time：2017年1月20日
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Insert title here</title>
</head>
<body>
	<video id="video" autoplay="" style='width: 640px; height: 480px'></video>
	<div>
		<button id='picture' style="width: 100%;">PICTURE</button>
	</div>
	<canvas id="canvas" width="640" height="480"></canvas>
	<script type="text/javascript">
		var video = document.getElementById("video");
		var context = canvas.getContext("2d");
		var errocb = function() {
			console.log('sth wrong!');
		}

		if (navigator.getUserMedia) { // 标准的API  
			navigator.getUserMedia({
				"video" : true
			}, function(stream) {
				video.src = stream;
				video.play();
			}, errocb);
		} else if (navigator.webkitGetUserMedia) { // WebKit 核心的API  
			navigator.webkitGetUserMedia({
				"video" : true
			}, function(stream) {
				video.src = window.webkitURL.createObjectURL(stream);
				video.play();
			}, errocb);
		}

		document.getElementById("picture").addEventListener("click",
				function() {
					context.drawImage(video, 0, 0, 640, 480);
				});
	</script>
</body>
</html>