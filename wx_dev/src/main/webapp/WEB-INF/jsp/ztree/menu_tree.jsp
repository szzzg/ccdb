<!--
@author: 周志刚
@phone：15295621977
@E-mail：szzzg@126.com
@Description: 
@create time：2017年2月20日
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
<title>树状菜单</title>
<link rel="stylesheet" href="${ctx}/assets/plugin/zTree_v3/css/demo.css">
<link rel="stylesheet"
	href="${ctx}/assets/plugin/zTree_v3/css/zTreeStyle/zTreeStyle.css">
<%@include file="/WEB-INF/common-inc/init.jsp"%>
<script src="${ctx}/assets/plugin/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	var zTreeObj;
	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	var setting = {
		callback : {
			onClick : zTreeOnClick
		}
	};
	// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
	var zNodes = ${jsonObj};
	$(document).ready(function() {
		zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});

	function zTreeOnClick(event, treeId, treeNode) {
		console.log("treeId>>"+treeId);
		console.log(treeNode);
		alert(treeNode.tId + ", " + treeNode.name);
	}

	var MenuBtn = {
			
	}
</script>
</head>
<body>

	<div>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div id="ssss" style="float: left; border: 1px solid #f0ad4e;">
		<button type="button" id="updGroup" onclick="">修改组织架构</button>
		<button type="button" id="addGroup" onclick="">添加组织架构</button>
		<button type="button" id="addUser" onclick="">添加用户</button>
	</div>
</body>
</html>