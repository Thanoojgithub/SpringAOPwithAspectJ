package org.springframework.samples.springaop.service;

import org.springframework.samples.springaop.vo.User;

public interface UserService {
	
	public User getUserProfile(Integer id, String name);
	public User getUserProfileBeforeAdviceAfterReturningAdvice(Integer id, String name);
	public User getUserProfileAroundAdvice(Integer id, String name);
	public User getUserProfileWithException(Integer id, String name) throws Exception;

}
