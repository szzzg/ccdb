<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vue 测试实例 - 菜鸟教程(runoob.com)</title>
<script src="https://cdn.bootcss.com/vue/2.4.2/vue.min.js"></script>
<script src="https://cdn.bootcss.com/vue-router/2.7.0/vue-router.min.js"></script>
<script
	src="https://cdn.bootcss.com/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>

	<div id="app">

		<button @click="ajaxCallGetMethod">{{getBtn}}</button>
		<button @click="ajaxCallPostMethod">{{postBtn}}</button>
		<button @click="ajaxCallPostMethod2">{{postBtn}}</button>
		<button @click="ajaxCallPostMethod3">{{postBtnReturnJSONP}}</button>
		<button @click="ajaxCallGetStudents">{{getBtnReturnLIST}}</button>

		<div v-if="resGETMessage != null">{{resGETMessage}}</div>
		<div v-if="resPOSTGETMessage != null">{{resPOSTGETMessage}}</div>
		<div v-if="resPOSTGETMessage2 != null">{{resPOSTGETMessage2}}</div>
		<div v-if="resPOSTGETMessage3 != null">{{resPOSTGETMessage3}}</div>
		<div v-if="resDate.length > 0">1:{{resDate}}</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="obj in resListData">
						<td>{{obj.name}}</td>
						<td>{{obj.sex}}</td>
						<td>{{obj.age}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<script>
		new Vue({
			el : '#app',
			data : {
				getBtn : 'ajax调用 GET请求',
				postBtn : 'ajax调用 POST请求',
				postBtnReturnJSONP : 'ajax调用 POST请求返回JSONP',
				getBtnReturnLIST : 'ajax请求获取表格列表数据',
				resGETMessage : null,
				resPOSTGETMessage : null,
				resPOSTGETMessage2 : null,
				resPOSTGETMessage3 : null,
				resDate : {}, //JSONP回调函数 返回数据
				resListData :[]
			},
			methods : {
				ajaxCallGetMethod : function() {
					// => ES6简写语法
					this.$http.get("http://localhost:8080/restful-api-spring/api/sayHi/hello").then(res => {
						console.log(res);
						this.resGETMessage = res.body;
					})
				},
				ajaxCallPostMethod : function() {
					this.$http.post("http://localhost:8080/restful-api-spring/api/sayHello/周志刚",{emulateJSON:true}).then(res => {
						console.log(res);
						this.resPOSTGETMessage = res.body;
					})
				},
				ajaxCallPostMethod2 : function() {
					let postData = {'name':'周志刚','age': 28,'sex':'男'};
					let options = {emulateJSON:false};
					// emulateJSON 的作用： 如果Web服务器无法处理编码为 application/json 的请求，你可以启用 emulateJSON 选项。 默认值 false 
					this.$http.post("http://localhost:8080/restful-api-spring/api/receiveJsonToStr", postData,options).then(function(res) {
						console.log(res);
						this.resPOSTGETMessage2 = res.body;
					})
				},
				ajaxCallPostMethod3 : function() {
					let options ={
						jsonp: 'callback' // 设置回调函数的参数的一个名字，默认是话是callback
					};
					this.$http.jsonp("http://localhost:8080/restful-api-spring/api/sayHi/周志刚" , options).then(function(res) {
						console.log(res.resDate.s);
						this.resPOSTGETMessage3 = res.resDate.s;
						//this.$set('resData',res);
					})
/* 					this.$http.jsonp('https://sp0.baidu.com/5a1Fazu8AA54nxGko9WTAnF6hhy/su',{params:{ wd:'a' },jsonp:'cb'}).then(resp => {
						console.log(resp.data.s);
					}); */
				},
				ajaxCallGetStudents : function() {
					this.$http.get("http://localhost:8080/restful-api-spring/api/tableList").then(res => {
						console.log(res.body);
						this.resListData = res.body;
					})
				}
			}
		})
	</script>
</body>
</html>