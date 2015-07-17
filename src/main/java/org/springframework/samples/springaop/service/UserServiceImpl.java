package org.springframework.samples.springaop.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.samples.springaop.aop.exception.InValidUserException;
import org.springframework.samples.springaop.vo.User;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

	public User getUserProfile(Integer id, String name) {
		User user = new User(id, name);
		LOG.log(Level.INFO, "user :: "+user);
		return user;
	}

	public User getUserProfileWithException(Integer id, String name) throws Exception {
		if(id < 0 || (name == "" || name == null)){
			throw new InValidUserException("please provide valid inputs to construct User instance");
		}else{
			return new User(id, name);
		}
	}
	
	
	
}
