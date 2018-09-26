/**
 * 多图片上传(预压缩Base64)
 */

var MulitUpload = {
	// 删除照片
	deletePhoto : function(e) {
		console.log($(e).parents(".d_container"));
		$(e).parents(".d_container").remove();
		if ($(":file[style='display:none;']").length == 4) {
			console.log($("span[class='d_container'] :last"));
			$(":file[style='display:none;']:last").parents("span[class='d_container']")
				.after("<span class='d_container'><img class='picStyle picLayout' src='"
						+ pathName
						+ "/assets/image/addPic.png'/><input class='fileMulit' type='file' onchange='MulitUpload.changePhoto(this)' name='pictrue' value='浏览'></span>");
		}
	},
	// 修改图片
	changePhoto:function(e){
		 // -----------Base64压缩-------------
		// 也可以传入图片路径：lrz('../demo.jpg', ...
		lrz(e.files[0],{
			width : 1200,
			height : 900,
			before : function() {
				console.log('压缩开始');
			},
			fail : function(err) {
				console.error(err);
			},
			always : function() {
				console.log('压缩结束');
			},
			done : function(results) {
				// 你需要的数据都在这里，可以以字符串的形式传送base64给服务端转存为图片。
				console.log(results);
				$(e).attr({
					style : "display:none;"
				});
				$(e).prev().remove();
				$(e).before("<img src='"
					+ results.base64
					+ "' class='picStyle picLayout'><div class='d_circle' onclick='MulitUpload.deletePhoto(this)'>X</div>");
				if ($(":file").length < 5) {
					$(e).parents(".d_container").
						after("<span class='d_container'><img class='picStyle picLayout' src='"
								+ pathName
								+ "/assets/image/addPic.png'/><input class='fileMulit' type='file'onchange='MulitUpload.changePhoto(this)' name='pictrue' value='浏览'></span>");
				}
			}
		});
	},
	// 提交
	btn_commit : function(){
		if($("input[type='file']:last").val() == ''){
			$("input[type='file']:last").remove();
		}
		console.log($('#photo_container').find('img').length);
		var imgs = $('#photo_container').find('img');
		for (var i = 0; i < imgs.length - 1; i++) {
			console.log(imgs[i]);
			$("#hidden_container").append("<input type='hidden' name='photo' value='" + imgs[i].src + "'/>");
		}

		$("#form1").submit();
	}
}