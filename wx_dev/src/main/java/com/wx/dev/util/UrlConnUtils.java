package com.wx.dev.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年11月21日下午2:43:49
 * @author: 周志刚
 * @ClassName: UrlConnUtils
 * @Description: TODO
 */
public class UrlConnUtils {

	/**
	 * POST请求
	 * 
	 * @param postUrl
	 * @param postData
	 * @return
	 * @throws IOException
	 */
	public static String postUrlConn(String postUrl, String postData)
			throws IOException {

		URL url = new URL(postUrl);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				"application/json; charset=utf-8");

		conn.connect();

		if (postData != null) {
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			out.write(postData.getBytes());
		}

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));

		String line;
		String json = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
			json += line;
		}

		rd.close();

		return json;
	}

	/**
	 * GET请求
	 * 
	 * @param getUrl
	 * @return
	 * @throws IOException
	 */
	public static String getUrlConn(String getUrl) throws IOException {

		URL url = new URL(getUrl);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type",
				"application/json; charset=utf-8");

		conn.connect();

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));

		String line;
		String json = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
			json += line;
		}

		rd.close();

		return json;
	}
}
