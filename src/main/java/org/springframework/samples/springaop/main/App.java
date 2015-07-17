package org.springframework.samples.springaop.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.springaop.service.UserService;
import org.springframework.samples.springaop.vo.User;

public class App {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml")){
			UserService userService = (UserService) context.getBean("userService");
			User userProfile = userService.getUserProfile(1,"sriram");
			System.out.println(userProfile);
		}
	}
}
