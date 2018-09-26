package com.wx.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年2月12日下午10:11:18
 * @author: 周志刚
 * @ClassName: MulitPhotoController
 * @Description: TODO
 */
@Controller
@RequestMapping("/mulit")
public class MulitPhotoController {

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view() {
		return "mulit_upload/mulit_photo";
	}

	@RequestMapping(value = "/localResizeView", method = RequestMethod.GET)
	public String localResizeView() {
		return "mulit_upload/mulit_photo_upload_preview";
	}
}
