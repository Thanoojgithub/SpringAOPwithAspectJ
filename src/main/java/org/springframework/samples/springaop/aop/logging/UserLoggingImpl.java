package org.springframework.samples.springaop.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.samples.springaop.aop.exception.InValidUserException;
import org.springframework.samples.springaop.vo.User;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserLoggingImpl implements UserLogging {

	private static final Logger LOG = LoggerFactory.getLogger(UserLoggingImpl.class);

	@Before(value = "execution(* org.springframework.samples.springaop.service.UserService.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		LOG.info("beforeAdvice :: " + joinPoint.toString());
	}

	@After(value = "execution(* org.springframework.samples.springaop.service.UserService.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		LOG.info("afterAdvice :: " + joinPoint.toString());
	}

	@AfterReturning(pointcut = "execution(* org.springframework.samples.springaop.service.UserService.*(..))", returning = "retVal")
	public void afterReturningAdvice(JoinPoint joinPoint, User retVal) {
		LOG.info("afterReturningAdvice :: " + joinPoint.toString());
		LOG.info("afterReturningAdvice after proceed :: " + retVal);
	}

	@Around(value = "execution(* org.springframework.samples.springaop.service.UserService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		LOG.info("aroundAdvice before proceed");
		User user = null;
		Object proceed = joinPoint.proceed();
		if (proceed instanceof User) {
			user = (User) proceed;
			user.setName("aroundAdvice after proceed");
			LOG.info("aroundAdvice after proceed :: " + user);
		}
		return user;
	}

	@AfterThrowing(pointcut = "execution(* org.springframework.samples.springaop.service.UserService.*(..))", throwing = "ex")
	public void AfterThrowingAdvice(JoinPoint joinPoint, InValidUserException ex) {
		LOG.info("There has been an exception: " + ex.toString());
	}

}
