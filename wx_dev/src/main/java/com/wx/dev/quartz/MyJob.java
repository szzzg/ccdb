package com.wx.dev.quartz;

import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年11月28日下午6:57:53
 * @author: 周志刚
 * @ClassName: MyJob
 * @Description: TODO
 */
@Repository
public class MyJob {
	public void work() {
		System.out.println("date:" + new Date().toString());
	}
}
