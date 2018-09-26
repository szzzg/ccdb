package dev.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * @ProjectName: wx_dev
 * @version create time：2016年12月13日下午4:07:47
 * @author: 周志刚
 * @ClassName: ThreadTestCase
 * @Description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ThreadTestCase {
	
	@Resource
	private MulitDataThread t1;

	@Test
	public void runThread(){
		new Thread(t1,"线程1").run();
		new Thread(t1,"线程2").run();
		new Thread(t1,"线程3").run();
		new Thread(t1,"线程4").run();
	}
	
}
