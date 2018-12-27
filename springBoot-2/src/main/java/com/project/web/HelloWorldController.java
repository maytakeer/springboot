package com.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//controller里面的方法都以json格式输出
@Controller
public class HelloWorldController {

	/*
	 * @RequestMapping("/hello") public String index(){ return "Hello World"; }
	 */

	@RequestMapping("/he")
	public String index1() {
		return "hahaha";
	}

	@RequestMapping("/hello")
	public String hello(
			Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "hello";
	}
}
