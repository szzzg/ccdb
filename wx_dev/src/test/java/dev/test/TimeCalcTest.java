package dev.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * @ProjectName: wx_dev
 * @version create time：2016年12月7日下午1:49:05
 * @author: 周志刚
 * @ClassName: TimeCalcTest
 * @Description: TODO
 */
public class TimeCalcTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		long curTimeNum = new Date().getTime();
		System.out.println(curTimeNum);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long recordTimeNum = sdf.parse("2016-12-08 13:59:00").getTime();
		System.out.println(recordTimeNum);
		
		System.out.println(recordTimeNum - curTimeNum);
		
		float num = (recordTimeNum - curTimeNum)/3600/1000;
		System.out.println(num);
	}

}
