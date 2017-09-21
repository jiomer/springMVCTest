package com.glj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.glj.pojo.User;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
public class UserController {
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password, ModelAndView mav,
			HttpSession sesssion) {
		if (loginname != null && loginname.equals("admin") && password != null
				&& password.equals("admin")) {
			User user = new User();
			user.setLoginname(loginname);
			user.setPassword(password);
			user.setUsername("管理员");
			sesssion.setAttribute("user", user);
			mav.setViewName("redirect:main");
		}else{
			mav.addObject("message","登录名或密码错误!");
			mav.setViewName("loginForm");
		}
		return mav;

	}
	@RequestMapping("/{formName}")
	public String loginForm(@PathVariable String formName){
		return formName;
	}
	
}
