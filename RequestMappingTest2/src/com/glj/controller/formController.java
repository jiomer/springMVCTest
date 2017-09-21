package com.glj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.glj.pojo.User;
@Controller
public class formController {
	@RequestMapping(value="/formTest",method=RequestMethod.GET)
	public String registerForm(Model model){
		User user = new User();
		user.setLoginname("test");
		user.setPassword("123");
		user.setUsername("admin");
		model.addAttribute("user",user);
		return "testForm";
	}
}
