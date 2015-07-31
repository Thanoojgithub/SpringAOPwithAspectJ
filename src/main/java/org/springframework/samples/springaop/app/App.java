package org.springframework.samples.springaop.app;

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
			User userProfileAroundAdvice = userService.getUserProfileAroundAdvice(3, "Lakshman");
			System.out.println(userProfileAroundAdvice);
			User userProfileBeforeAdviceAfterReturningAdvice = userService.getUserProfileBeforeAdviceAfterReturningAdvice(2,"seetha");
			System.out.println(userProfileBeforeAdviceAfterReturningAdvice);
			try {
				User userProfileWithException = userService.getUserProfileWithException(-1, "");
				System.out.println(userProfileWithException);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
