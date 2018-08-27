<!--
@author: 周志刚
@phone：15295621977
@E-mail：szzzg@126.com
@Description: 
@create time：2018年8月8日
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
<title>Hello Word</title>
<script type="text/javascript" src="${ctx}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#test_api_btn").click(function() {
			alert("触发事件");
			var jsonStr = '{"username":"张三","password":"Qazwsx12"}';
			$.ajax({
				url:'${ctx}/api/receiveStr/' + encodeURIComponent("abc1234的值"),
				type:'post',
				//data: JSON.parse(jsonStr),
				//data: {"username":"张三"},
				data: jsonStr,
				dataType:'text',
				success:function(res){
					console.log(res);
				}
			})
		})
		$("#form_test_api_btn").click(function() {
			alert("表单提交触发事件");
			$.ajax({
				url:'${ctx}/api/receiveStr/abc1234的值',
				type:'post',
				data:$("#form1").serialize(),
				dataType:'text',
				success:function(res){
					console.log(res);
				}
			})
		})
	})
</script>
</head>
<body>
	<button type="button" id="test_api_btn">测试接口</button>
	
	<form action="" id="form1">
	<input type="text" name="username" placeholder="username" />
	<input type="text" name="username" placeholder="password" />
	<button type="button" id="form_test_api_btn">提交</button>
	</form>
</body>
</html>