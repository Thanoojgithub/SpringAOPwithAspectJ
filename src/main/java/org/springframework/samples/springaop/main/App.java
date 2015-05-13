package org.springframework.samples.springaop.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.springaop.service.UserService;
import org.springframework.samples.springaop.vo.User;

public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService userService = (UserService) context.getBean("userService");
		User userProfile = userService.getUserProfile();
		System.out.println(userProfile);
		context.close();

	}
}
