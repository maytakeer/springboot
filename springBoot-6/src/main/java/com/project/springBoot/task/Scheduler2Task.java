package com.project.springBoot.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler2Task {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	//@Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
	//@Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
	//@Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
	@Scheduled(fixedRate = 6000)
	public void process(){
		System.out.println("现在时间：" + DATE_FORMAT.format(new Date()));
	}
}
