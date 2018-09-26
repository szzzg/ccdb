package dev.test;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年11月28日下午5:51:37
 * @author: 周志刚
 * @ClassName: HelloQuartzJob
 * @Description: TODO
 */
public class HelloQuartzJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("Hello, Quartz! - executing its JOB at "
				+ new Date() + " by ");
	}

}
