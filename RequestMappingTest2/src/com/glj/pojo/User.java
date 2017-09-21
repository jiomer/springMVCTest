package com.glj.pojo;

public class User {
	//私有字段
	private String loginname;
	private String password;
	private String username;
	//无参构造器
	public User(){
		super();
	}
	// get and set方法
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
