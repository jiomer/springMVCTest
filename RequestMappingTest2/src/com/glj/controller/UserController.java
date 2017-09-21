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
	//��̬List<User>���ϣ��˴�����ģ�����ݿ�������ע���û�����Ϣ
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	private static List<User> userlist;
	
	public UserController() {
		super();
		userlist = new ArrayList<User>();
	}
	//����֧��get
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerForm(){
		//��ת��registerFormҳ��
		return "registerForm";
	}
	//����֧��post
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(
			@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			@RequestParam("username") String username
			){
		logger.info("register post��������");
		
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		user.setUsername(username);
		//ģ�����ݿⴢ��user
		userlist.add(user);
		return "loginForm";
	}
	
	@RequestMapping(value="/login")
	public String login(
			@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			Model model
			){
		logger.info("loginname"+loginname+"����"+password);
		
		//��userlist������鿴�Ƿ������Ϣ���˴�����ģ�����ݿ���֤
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
