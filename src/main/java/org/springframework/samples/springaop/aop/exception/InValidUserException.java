package org.springframework.samples.springaop.aop.exception;

public class InValidUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public InValidUserException(String msg) {
		super(msg);
	}

}
