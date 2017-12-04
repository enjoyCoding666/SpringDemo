package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopRun {

	public static void main(String[] args) throws Exception {

		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		IAopService hello = (IAopService) context.getBean("aopService");

		hello.withAop();
		hello.withoutAop();


	}
}
