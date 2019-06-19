package com.aaa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aaa.entity.Employee;
import com.aaa.util.EmpUtil;

public class LoginInterceptor implements HandlerInterceptor{
	
	/**  登录拦截业务
	 *  1 获取session中的用户信息
	 *  2 如果为空 证明没有登录 则 返回false 并重定向到 登录界面
	 *  3 如果不为空 则 放行 true
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		
		Employee emp = EmpUtil.getEmp();
		
		if(emp == null){
			resp.sendRedirect("/ssm");
			return false;
		}
		
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

}
