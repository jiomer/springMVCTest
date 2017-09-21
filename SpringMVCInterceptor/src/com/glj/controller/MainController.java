package com.glj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainController {
	@RequestMapping("/main")
	public String main(Model model){
		String mainMessage = "This is mainController";
		model.addAttribute("mainMessage",mainMessage);
		return "main";
	}
}
