package com.glj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jiomer
 *
 */
@Controller
public class helloController {
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("test");
		return "welcome";
	}
}
