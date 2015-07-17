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
import org.springframework.samples.springaop.aop.exception.InValidUserException;
import org.springframework.samples.springaop.vo.User;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserLoggingImpl implements UserLogging {

	private static final Logger LOG = Logger.getLogger(UserLoggingImpl.class
			.getName());

	@Before(value = "execution(* org.springframework.samples.springaop.service.UserService.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		LOG.log(Level.INFO, "beforeAdvice :: " + joinPoint.toString());
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
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		LOG.info("aroundAdvice before proceed");
		Object proceed = joinPoint.proceed();
		if (proceed instanceof User) {
			User user = (User) proceed;
			user.setName("aroundAdvice after proceed");
			LOG.info("aroundAdvice after proceed :: " + user);
		}
	}

	@AfterThrowing(pointcut = "execution(* org.springframework.samples.springaop.service.UserService.*(..))", throwing = "ex")
	public void AfterThrowingAdvice(JoinPoint joinPoint, InValidUserException ex) {
		LOG.info("There has been an exception: " + ex.toString());
	}

}
