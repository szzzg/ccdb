/**
 * 多图片上传
 */

var MulitUpload = {
	// 删除照片
	deletePhoto : function(e) {
		console.log($(e).parents(".d_container"));
		$(e).parents(".d_container").remove();
		if ($(":file[style='display:none;']").length == 4) {
			console.log($("span[class='d_container'] :last"));
			$(":file[style='display:none;']:last").parents("span[class='d_container']").after("<span class='d_container'><img class='picStyle picLayout' src='"+pathName+"/assets/image/addPic.png' /><input class='fileMulit' type='file' onchange='MulitUpload.changePhoto(this)' name='pictrue' value='浏览'></span>");
		}
	},
	// 修改图片
	changePhoto:function(e){
		var objUrl = MulitUpload.getObjectURL(e.files[0]);
		if (objUrl) {
			$(e).attr({style : "display:none;"});
			$(e).prev().remove();
			$(e).before("<img src='"
					+ objUrl
					+ "' class='picStyle picLayout'><div class='d_circle' onclick='MulitUpload.deletePhoto(this)'>X</div>");
			if($(":file").length < 5){
				$(e).parents(".d_container").after("<span class='d_container'><img class='picStyle picLayout' src='" + pathName + "/assets/image/addPic.png' /><input class='fileMulit' type='file' onchange='MulitUpload.changePhoto(this)' name='pictrue' value='浏览'></span>");
			}
		}
	},
	// 建立一個可存取到該file的url
	getObjectURL:function(file) {
		var url = null;
		if (window.createObjectURL != undefined) { // basic
			url = window.createObjectURL(file);
		} else if (window.URL != undefined) { // mozilla(firefox)
			url = window.URL.createObjectURL(file);
		} else if (window.webkitURL != undefined) { // webkit or chrome
			url = window.webkitURL.createObjectURL(file);
		}
		return url;
	},
	btn_commit : function(){
		if($("input[type='file']:last").val() == ''){
			$("input[type='file']:last").remove();
		}
	}
}