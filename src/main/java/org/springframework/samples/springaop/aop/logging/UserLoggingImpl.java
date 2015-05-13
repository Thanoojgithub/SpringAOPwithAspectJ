package org.springframework.samples.springaop.aop.logging;

import org.springframework.stereotype.Component;

@Component
public class UserLoggingImpl implements UserLogging {

	@Override
	public void beforeAdvice() {
		System.out.println("Going to setup User profile.");
	}

	@Override
	public void afterAdvice() {
		System.out.println("User profile has been setup.");
	}

	@Override
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning:" + retVal.toString());
	}

	@Override
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}

}
