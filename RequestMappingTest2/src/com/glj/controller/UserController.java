package com.glj.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.glj.pojo.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	//静态List<User>集合，此处用于模拟数据库来保存注册用户的信息
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	private static List<User> userlist;
	
	public UserController() {
		super();
		userlist = new ArrayList<User>();
	}
	//方法支持get
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerForm(){
		//挑转到registerForm页面
		return "registerForm";
	}
	//方法支持post
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(
			@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			@RequestParam("username") String username
			){
		logger.info("register post方法调用");
		
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		user.setUsername(username);
		//模拟数据库储存user
		userlist.add(user);
		return "loginForm";
	}
	
	@RequestMapping(value="/login")
	public String login(
			@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			Model model
			){
		logger.info("loginname"+loginname+"密码"+password);
		
		//到userlist集合里查看是否存在信息，此处用于模拟数据库验证
		for (User user : userlist) {
			if(user.getLoginname().equals(loginname)&&user.getPassword().equals(password)){
				model.addAttribute("user",user);
				return "welcome";
			}
			return "loginForm";
		}
		return "loginForm";
	}
}
