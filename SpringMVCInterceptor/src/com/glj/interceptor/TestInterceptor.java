package com.glj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.glj.pojo.User;

public class TestInterceptor implements HandlerInterceptor{
	private static final String[] IGNORE_URI = {"/loginForm","/login"};
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle");
		boolean flag = false;
		String servletPath = request.getServletPath();
		for (String s : IGNORE_URI) {
			if(servletPath.contains(s)){
				flag = true;
				break;
			}
		}
		if(!flag){
			User user = (User) request.getSession().getAttribute("user");
			if(user ==null){
				System.out.println("preHandle拦截请求:");
				request.setAttribute("message", "请先登录再访问");
				request.getRequestDispatcher("loginForm").forward(request, response);
			}else{
				System.out.println("拦截放行");
				flag = true;
			}
		}
		return flag;
	}
	
}
