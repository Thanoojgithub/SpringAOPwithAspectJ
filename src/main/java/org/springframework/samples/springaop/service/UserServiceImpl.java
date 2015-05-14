package org.springframework.samples.springaop.service;

import org.springframework.samples.springaop.vo.User;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	public User getUserProfile(Integer id, String name) {
		return new User(id, name);
	}
	
	public User getUserProfileWithException(Integer id, String name) throws Exception {
		if(0<1){
			throw new Exception();
		}
		return new User(id, name);
	}

}
