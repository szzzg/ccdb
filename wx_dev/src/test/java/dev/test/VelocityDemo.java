package dev.test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * @ProjectName: wx_dev
 * @version create time：2018年2月23日上午11:24:06
 * @author: 周志刚
 * @ClassName: VelocityDemo
 * @Description: TODO
 */
public class VelocityDemo {

	static Log _log = LogFactoryImpl.getLog(VelocityDemo.class);

	public static void main(String[] args) {

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		ve.setProperty(Velocity.INPUT_ENCODING, "UTF-8");// 设置输入字符集
		ve.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");// 设置输出字符集

		ve.init();

		Template t = ve.getTemplate("mail-template.vm");
		VelocityContext ctx = new VelocityContext();
		ctx.put("userName", "张三");

		List<String> listUrl = new ArrayList<String>();
		listUrl.add("www.sohu.com");
		listUrl.add("www.163.com");
		listUrl.add("www.qq.com");
		listUrl.add("www.baidu.com");
		ctx.put("onlineData", listUrl);

		List<FileInfo> listFileInfos = new ArrayList<FileInfo>();
		FileInfo fi = new FileInfo();
		fi.setName("三月份对账单");
		fi.setDownloadUrl("http://www.163.com");
		listFileInfos.add(fi);
		FileInfo fi1 = new FileInfo();
		fi1.setName("四月份对账单");
		fi1.setDownloadUrl("http://www.qq.com");
		listFileInfos.add(fi1);
		ctx.put("ObjData", listFileInfos);

		StringWriter writer = new StringWriter();

		t.merge(ctx, writer);

		_log.info(">>>>>>>>>>邮件内容打印>>>>>>>>>>");
		_log.info(writer);

	}

}
