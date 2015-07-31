package org.springframework.samples.springaop.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.samples.springaop.aop.exception.InValidUserException;
import org.springframework.samples.springaop.vo.User;

public interface UserLogging {
	
	public void beforeAdvice(JoinPoint joinPoint);

	public void afterAdvice(JoinPoint joinPoint);

	public void afterReturningAdvice(JoinPoint joinPoint, User retVal);

	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable;

	public void AfterThrowingAdvice(JoinPoint joinPoint, InValidUserException ex);

}
