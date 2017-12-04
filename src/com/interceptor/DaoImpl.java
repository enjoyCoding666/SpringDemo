package com.interceptor;

/**
 * Created by lenovo on 2017/4/27.
 */
public class DaoImpl implements IDao {

    @Override
    public String sayHello(String name) {
        return "hello,"+name;
    }
}
