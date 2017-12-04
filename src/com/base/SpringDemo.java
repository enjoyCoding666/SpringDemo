package com.base;

import org.springframework.ui.ModelMap;

/**
 * Created by lenovo on 2017/4/26.
 */
public class SpringDemo {
      public String printWelcome(ModelMap modelMap){
           modelMap.addAttribute("message","hello world");
           return "hello";
      }
}
