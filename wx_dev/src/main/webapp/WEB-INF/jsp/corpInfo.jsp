<!--
@author: 周志刚
@phone：15295621977
@E-mail：szzzg@126.com
@Description: 
@create time：2016年11月25日
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
<title>企业号配置</title>
<%@include file="/WEB-INF/common-inc/init.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<form role="form" action="${ctx}/qiye/saveCorpInfo" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">企业号Name</label> <input type="text"
					class="form-control" id="name" name="corpname" required="required"
					autocomplete="off" placeholder="企业号Name">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">企业号CorpId</label> <input type="text"
					class="form-control" id="corpId" name="corpid" required="required"
					autocomplete="off" placeholder="企业号CorpId">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">企业号CorpSecret</label> <input
					type="text" class="form-control" id="corpSecret" name="corpsecret"
					autocomplete="off" required="required" placeholder="企业号CorpSecret">
			</div>
			<button type="submit" class="btn btn-default">提交</button>
		</form>
		<table
			class="table table-striped table-bordered table-condensed table-hover">
			<caption>企业号信息</caption>
			<thead>
				<tr>
					<th>CorpName</th>
					<th>CorpId</th>
					<th>CorpSecret</th>
					<th>AccessToken</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ls" items="${jstl_corpInfoLst}">
					<tr>
						<td>${ls.corpname}</td>
						<td>${ls.corpid}</td>
						<td>${ls.corpsecret}</td>
						<td>${ls.accesstoken}</td>
						<td><button class="btn btn-primary"
								onclick="Corp.generateToken('${ls.id}')">Token刷新</button></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot></tfoot>
		</table>
	</div>

	<script type="text/javascript">
		var Corp = {
			name : '${ctx}',
			generateToken : function(id) {
				location.href = Corp.name + "/qiye/accessToken/" + id;
			}
		}
	</script>
</body>
</html>