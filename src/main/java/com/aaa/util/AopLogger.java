package com.aaa.util;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AopLogger {
	 private Logger log =  LoggerFactory.getLogger(this.getClass());

	ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	// 申明一个切点 里面是 execution表达式
	@Pointcut("execution(public * com.aaa.controller.*Controller.*(..))")
	void controllerAspect() {
	}

	// 请求method前打印内容
	@Before("controllerAspect()")
	public void methodBefore(JoinPoint joinPoint) {
		startTime.set(System.currentTimeMillis());
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = (HttpServletRequest) requestAttributes
				.getRequest();
		// 打印请求内容
		log.info("===============请求内容===============");
		log.info("请求地址:" + request.getRequestURL().toString());
		log.info("请求方式:" + request.getMethod());
		log.info("请求类方法:" + joinPoint.getSignature());
		log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
		log.info("===============请求内容===============");
	}

	// 在方法执行完结后打印返回内容
	@AfterReturning(value = "controllerAspect()",returning = "result")
	public void methodAfterReturing(Object result) {
		log.info("--------------返回内容----------------");
		log.info("Response内容:" + result);
		log.info("--------------返回内容----------------");
		log.info("请求处理时间为:" + (System.currentTimeMillis() - startTime.get()));

	}
}
