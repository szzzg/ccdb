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
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${ctx}/assets/plugin/bootstrap/dist/css/bootstrap.min.css">
<script src="${ctx}/assets/js/jquery-1.11.3.min.js"></script>
<script src="${ctx}/assets/plugin/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/js/jweixin-1.1.0.js"></script>
<script type="text/javascript">
/* 	$(function() {
		$.ajax({
			url : '${ctx}/jssdk/getSdkConfigParam',
			type : 'POST',
			data : {
				'urlAddr' : location.href
			},
			dataType : 'json',
			success : function(res) {

				alert("hello");

				wx.config({
					debug : true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
					appId : res.appId, // 必填，企业号的唯一标识，此处填写企业号corpid
					timestamp : res.timestamp, // 必填，生成签名的时间戳
					nonceStr : res.nonceStr, // 必填，生成签名的随机串
					signature : res.signature,// 必填，签名，见附录1
					jsApiList : [ 'onMenuShareTimeline', 'onMenuShareQQ',
							'onMenuShareWeibo' ]
				// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
				});
			}
		})
	})

	wx.ready(function() {
		// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
		wx.scanQRCode({
			desc : 'scanQRCode desc',
			needResult : 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
			scanType : [ "qrCode", "barCode" ], // 可以指定扫二维码还是一维码，默认二者都有
			success : function(res) {
				// 回调
			},
			error : function(res) {
				if (res.errMsg.indexOf('function_not_exist') > 0) {
					alert('版本过低请升级')
				}
			}
		});
		wx.onMenuShareTimeline({
			title : '分享标题', // 分享标题
			link : location.href, // 分享链接
			imgUrl : '', // 分享图标
			success : function() {
				// 用户确认分享后执行的回调函数
				$.ajax({
					url : '${addIntegral}',
					type : 'post',
					async : false,
					success : function(data) {
						console.log(data);
					}
				})
			},
			cancel : function() {
				// 用户取消分享后执行的回调函数
			}
		});

	});
	wx.error(function(res) {
		// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
	}); */
</script>
</head>
<body>
	<ul>
		<li><a href="${ctx}/qiye/dispacthCorpInfo">企业号</a></li>
		<li><a href="">服务号</a></li>
	</ul>
</body>
</html>