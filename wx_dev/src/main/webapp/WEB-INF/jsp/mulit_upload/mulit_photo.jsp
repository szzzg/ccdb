<!--
@author: 周志刚
@phone：15295621977
@E-mail：szzzg@126.com
@Description: 
@create time：2017年2月12日
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
<title>多文件原图片上传</title>
<link type="text/css" rel="stylesheet"
	href="${ctx}/assets/css/commPic.css">
<%@include file="/WEB-INF/common-inc/init.jsp"%>
<script src="${ctx}/assets/js/mulit_upload.js"></script>
<style type="text/css">
.pic_size {
	width: 24px;
	height: 24px;
}
</style>
</head>
<body>
	<form method="post" action="${doUploadUrl}">
		<div class="form-group">
			<img src="${ctx}/assets/image/sumCount.png" class="pic_size" />查询的产品总数量
			<button type="button" class="btnAlign" id="subtract">-</button>
			<input type="number" id="number" style="margin-top: -2px;"
				name="<portlet:namespace/>goodsCount" class="input-mini" value="100" />
			<button type="button" class="btnAlign" id="add">+</button>
		</div>
		<hr />

		<div class="form-group">
			<label for="remark"><img
				src="${ctx}/assets/image/question.png" class="pic_size" />问题描述</label>
			<textarea rows="6" name="remark" placeholder="介绍描述"></textarea>
		</div>
		<hr />
		<div class="form-group">
			<label for="phone"><img src="${ctx}/assets/image/phone.png"
				class="pic_size" />联系方式</label> <input type="number" name="phone"
				class="form-control" placeholder="联系方式">
		</div>
		<hr />
		<div class="form-group">
			<label for="pictrue"><img
				src="${ctx}/assets/image/picture.png" class="pic_size" />图片资料</label>
		</div>
		<div id="photo_container">
			<span class="d_container"> <img class="picStyle picLayout"
				src="${ctx}/assets/image/addPic.png" /> <input type="file"
				class="fileMulit" name="pictrue"
				onchange="MulitUpload.changePhoto(this)" value="浏览">
			</span>
		</div>
		<div class="form-group">
			<button type="button" onclick="MulitUpload.btn_commit()" class="btn btn-primary">提交</button>
		</div>
	</form>
</body>
</html>