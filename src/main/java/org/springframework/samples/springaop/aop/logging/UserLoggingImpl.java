package org.springframework.samples.springaop.aop.logging;

import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.samples.springaop.vo.User;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserLoggingImpl implements UserLogging {
	
	private final org.apache.commons.logging.Log LOG = LogFactory.getLog(this.getClass());

	@Before("within(org.springframework.samples.springaop..*)")
	public void beforeAdvice(JoinPoint joinPoint) {
		LOG.info("beforeAdvice :: "+joinPoint.toString());
	}

	@After("within(org.springframework.samples.springaop..*)")
	public void afterAdvice(JoinPoint joinPoint) {
		LOG.info("afterAdvice :: "+joinPoint.toString());
	}

	@AfterReturning("within(org.springframework.samples.springaop..*)")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		LOG.info("afterReturningAdvice ::" + result.toString());
	}

	@Around("within(org.springframework.samples.springaop..*)")
	public void aroundAdvice(ProceedingJoinPoint joinPoint, Object retVal) throws Throwable {
		User user = (User)retVal;
		user.setName("raghuram");
		LOG.info("aroundAdvice before proceed :: "+user);
		Object proceed = joinPoint.proceed();
		user = (User)proceed;
		user.setName("raghuram updated");
		LOG.info("aroundAdvice after proceed :: "+user);
	}

	@AfterThrowing("within(org.springframework.samples.springaop..*)")
	public void AfterThrowingAdvice(JoinPoint joinPoint, IllegalArgumentException error) {
		LOG.info("There has been an exception: " + error.toString());
	}

}
