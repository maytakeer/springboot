package com.project.springBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controller里面的方法都以json格式输出
@RestController
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String index(){
		return "Hello World";
	}
	
	@RequestMapping("/he")
	public String index1(){
		return "hahaha";
	}
}
