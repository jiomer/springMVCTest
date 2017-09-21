package com.glj.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0;

import com.glj.pojo.User;

@Controller
public class FileUploadController {
	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
				@RequestParam("fileName") String fileName,
				Model model)throws Exception{
		String path = request.getServletContext().getRealPath("/img/");
		File file = new File(path + File.separator + fileName);
		HttpHeaders headers = new HttpHeaders();
		String downloadFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		headers.setContentDispositionFormData("attachment", downloadFileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/register")
	public String register(HttpServletRequest request,
				Model model,
				@ModelAttribute User user
			)throws Exception{
		System.out.println(user.getUsername());
		if(!user.getImage().isEmpty()){
			//设置上传文件夹
			String path = request.getServletContext().getRealPath("/img/");
			//获取上传文件名
			String fileName = user.getImage().getOriginalFilename();
			//上传文件路径
			File filePath = new File(path,fileName);
			//判断路径是否存在，如果不存在就创建一个文件
			if(!filePath.getParentFile().exists()){
				filePath.getParentFile().mkdirs();
			}
			user.getImage().transferTo(new File(path + File.separator + fileName));
			model.addAttribute("user",user);
			return "userInfo";
		}
		return "error";
	}
	
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest request ,
				@RequestParam("description") String description,
				@RequestParam("file") MultipartFile file
			)throws Exception{
		System.out.println(description);
		if(!file.isEmpty()){
			//上传文件夹
			String path = request.getServletContext().getRealPath("/img/");
			//上传文件名
			String fileName = file.getOriginalFilename();
			//上传文件路径
			File filePath = new File(path,fileName);
			
			System.out.println(path);
			System.out.println(filePath);
			//判断路径是否存在，如果不存在就创建一个文件
			if(!filePath.getParentFile().exists()){
				filePath.getParentFile().mkdirs();
			}
			//将上传文件存到目标文件夹中
			file.transferTo(new File(path + File.separator + fileName));
			return "success";
		}else{
			return "error";			
		}

	}
	
	@RequestMapping(value="/{formName}")
	public String registerForm(@PathVariable String formName){
		//挑转到registerForm页面
		return formName;
	}
}
