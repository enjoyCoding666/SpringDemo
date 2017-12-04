package com.base;

/**
 * Created by lenovo on 2017/4/26.
 */
public class HelloWorld {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("调用HelloWorld的getMessage()方法获取的信息为: " + message);
    }
}