package dev.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年12月5日下午9:10:48
 * @author: 周志刚
 * @ClassName: UrlTest
 * @Description: TODO
 */
public class UrlTest {
	public static void main(String[] args) {
		String url = "http://www.nutrilonholland.com.cn/danone-nutrilon-portlet/api/traceability/getTraceability?key=NutrilonProsperous123&serialno=298637&country=";
		try {
			System.out.println(getUrlConn(url));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
