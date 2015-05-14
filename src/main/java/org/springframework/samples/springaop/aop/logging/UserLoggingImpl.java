package org.springframework.samples.springaop.aop.logging;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.samples.springaop.vo.User;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserLoggingImpl implements UserLogging {
	
	private static final Logger LOG = Logger.getLogger(UserLoggingImpl.class.getName());

	@Before("within(org.springframework.samples.springaop.service.*)")
	public void beforeAdvice(JoinPoint joinPoint) {
		LOG.log(Level.INFO, "beforeAdvice :: "+joinPoint.toString());
	}

	@After("within(org.springframework.samples.springaop.service.*)")
	public void afterAdvice(JoinPoint joinPoint) {
		LOG.info("afterAdvice :: "+joinPoint.toString());
	}

	@AfterReturning(value="execution(* org.springframework.samples.springaop..*.getUserProfile(..))", returning="object")
	public void afterReturningAdvice(JoinPoint joinPoint, Object object) {
		LOG.info("afterReturningAdvice :: " + joinPoint.toString());
		if(object instanceof User){
			User userObj = (User)object;
			userObj.setName("afterReturningAdvice");
			LOG.info("afterReturningAdvice after proceed :: "+object);
		}
	}

	@Around("within(org.springframework.samples.springaop.service.*)")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		LOG.info("aroundAdvice before proceed");
		LOG.info(joinPoint.getArgs().toString());
		Object proceed = joinPoint.proceed();
		if(proceed instanceof User){
		User user = (User)proceed;
		user.setName("aroundAdvice after proceed");
		LOG.info("aroundAdvice after proceed :: "+user);
		}
	}

	@AfterThrowing(value= "execution(* org.springframework.samples.springaop..*.getUserProfileWithException(..))", throwing ="error")
	public void AfterThrowingAdvice(JoinPoint joinPoint, Throwable error) {
		LOG.info("There has been an exception: " + error.toString());
	}

}
