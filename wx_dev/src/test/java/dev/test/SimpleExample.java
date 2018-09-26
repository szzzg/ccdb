package dev.test;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


/**
 * @ProjectName: wx_dev
 * @version create time：2016年11月28日下午5:53:58
 * @author: 周志刚
 * @ClassName: HelloQuartzScheduling
 * @Description: TODO
 */
public class SimpleExample {

	public static void main(String[] args) throws Exception {
		JobDetail jobDetail = JobBuilder.newJob(HelloQuartzJob.class)
				.withIdentity("testJob_1", "group_1").build();

		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("trigger_1", "group_1")
				.startNow()
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(10) // 时间间隔
								.withRepeatCount(5) // 重复次数(将执行6次)
				).build();
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		sched.scheduleJob(jobDetail, trigger);

		sched.start();

//		JobDetail jobDetail = JobBuilder.newJob(HelloQuartzJob.class).build();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Trigger trigger = TriggerBuilder.newTrigger().startAt(sdf.parse("2016-11-28 18:39:10")).build();
//		SchedulerFactory sf = new StdSchedulerFactory();
//		Scheduler sched = sf.getScheduler();
//		sched.scheduleJob(jobDetail, trigger);
//		sched.start();
	}
}
