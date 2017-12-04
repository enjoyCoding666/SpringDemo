package com.interceptor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by lenovo on 2017/4/28.
 */
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] objects, Object obj) throws Throwable {
        System.out.println("运行前检查");
        System.out.println("Method:"+method.getName());
        System.out.println("Args:"+ Arrays.asList(objects));
        System.out.println("Object:"+obj);
    }
}
