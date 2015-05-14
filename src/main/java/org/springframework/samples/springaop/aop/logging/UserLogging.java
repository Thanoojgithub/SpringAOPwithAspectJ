package org.springframework.samples.springaop.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface UserLogging {

	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	public void beforeAdvice(JoinPoint joinPoint);

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	public void afterAdvice(JoinPoint joinPoint);

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	public void afterReturningAdvice(JoinPoint joinPoint, Object retVal);
	
	/**
	 * 
	 * @param joinPoint
	 * @param retVal
	 * @throws Throwable
	 */
	public void aroundAdvice(ProceedingJoinPoint joinPoint, Object retVal) throws Throwable;

	/**
	 * This is the method which I would like to execute if there is an exception
	 * raised.
	 */
	public void AfterThrowingAdvice(JoinPoint joinPoint, IllegalArgumentException ex);

}
