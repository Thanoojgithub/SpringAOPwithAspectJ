package org.springframework.samples.springaop.service;

import org.springframework.samples.springaop.vo.User;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	public User getUserProfile() {
		return new User(1, "sriram");
	}

}
