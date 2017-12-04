package com.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MethodAfterInterceptor implements AfterReturningAdvice {
	@Override
	public void afterReturning(Object value, Method method, Object[] args,
							   Object instance) throws Throwable {
		System.out.println("方法 " + method.getName() + "运行完毕，返回值为：" + value);
	}
}
