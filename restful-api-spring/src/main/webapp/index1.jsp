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
			
			var ccdbStr = '{"monthAge":"7-9","accessChannel":"未推荐品牌品类","isQrcode":null,"treatment":"就医","serialNumber":"","wayOfEat":null,"disease":"吐奶","city":"苏州","userType":"对照组","noReason":null,"category":"","eatProduct":"纽康特","isEat":null,"province":"江苏","hospitalCode":"","babyDob":{"date":30,"day":6,"hours":0,"minutes":0,"month":11,"nanos":0,"seconds":0,"time":1514563200000,"timezoneOffset":-480,"year":117},"departmentId":"","createDate":{"date":9,"day":4,"hours":14,"minutes":11,"month":7,"nanos":377000000,"seconds":42,"time":1533795102377,"timezoneOffset":-480,"year":118},"district":null,"originalRegWay":"2","storeCode":"20300R","eatDate":"0","treatmentStage":"自我判断疑似过敏"}';
			console.log("请求数据：" + ccdbStr);
			//var jsonCCDBstr = JSON.parse(ccdbStr);
			$.ajax({
				url:'${ctx}/api/receiveJson/abc1234',
				type:'post',
				data:ccdbStr,
				//data: {"username":"张三"},
				//data: jsonStr,
				dataType:'text',
				success:function(res){
					console.log("MD5加密后：" + res);
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