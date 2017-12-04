package com.interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenovo on 2017/4/27.
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        IService is=(IService) context.getBean("service");
        is.service("超神锐");
    }
}
