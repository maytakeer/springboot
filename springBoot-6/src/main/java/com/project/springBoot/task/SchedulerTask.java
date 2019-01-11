package com.project.springBoot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class SchedulerTask {
	
	private int count = 0;
	
	//可以接受两种定时的设置，一种是我们常用的cron="*/6 * * * * ?",一种是 fixedRate = 6000，两种都表示每隔六秒打印一下内容。
	@Scheduled(cron="*/6 * * * * ?")
	private void process(){
		System.out.println("this is scheduled task runing" + (count++));
	}
	
}
