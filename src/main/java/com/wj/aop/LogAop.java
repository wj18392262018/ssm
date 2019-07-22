package com.wj.aop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wj.entity.SysLog;
import com.wj.service.ILogAopService;
@Component
@Aspect
public class LogAop {
	private Date visitTime;//时间
	private Class clazz;//访问类
	private Method method;//方法
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private ILogAopService logAopService;
	//获取访问时间、访问类、方法
	@Before("execution(* com.wj.controller.*.*(..))")
	public void doBefore() throws Exception{
	
	}
	
	@Around("execution(* com.wj.controller.*.*(..))")
	public Object doAround(ProceedingJoinPoint pjp)  {
		try {
			visitTime=new Date();//时间
	 		clazz=pjp.getTarget().getClass();
	 		String methodName=pjp.getSignature().getName();
	 		Object[]args=pjp.getArgs();
	 		Class[]params=new Class[args.length];//访问类
	 		for(int i=0;i<args.length;i++){
	 			params[i]=args[i].getClass();
	 		}
	 		method=clazz.getMethod(methodName, params);//method
			/*-----------------------*/
			//时长
	 		long time=new Date().getTime()-visitTime.getTime();
	 		//获取Ip
	 		String ip=request.getRemoteAddr();
	 		//获取username
	 		SecurityContext sc=SecurityContextHolder.getContext();
	 		User user=(User)sc.getAuthentication().getPrincipal();
	 		String username=user.getUsername();
	 		//获取url
	 		String url="";
	 		if(clazz!=null&method!=null&clazz!=LogAop.class){
	 			RequestMapping classRequestMapping=(RequestMapping)clazz.getAnnotation(RequestMapping.class);
	 			if(classRequestMapping!=null){
	 				String[]clazzValue=classRequestMapping.value();
	 				RequestMapping methodRequestMapping=method.getAnnotation(RequestMapping.class);
	 				String[]methodValue=methodRequestMapping.value();
	 				url=clazzValue[0]+methodValue[0];
	 		}
	 		}
	 		SysLog sysLog=new SysLog(UUID.randomUUID().toString().replace("-", ""),visitTime,visitTime.toLocaleString(),username,ip,url,time,method.getName());
	 		logAopService.addLog(sysLog);
	 		return pjp.proceed();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//获取访问时长、url、ip、username
	@After("execution(* com.wj.controller.*.*(..))")
	public void doAfter(){
		
	}
}