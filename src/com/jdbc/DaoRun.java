package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/5/10.
 */
public class DaoRun {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml") ;
        IPersonDao personDao=(IPersonDao) context.getBean("personDao");
        Person person=new Person();
        person.setBirthday(new Date());
        person.setSex("man");
        person.setAge(25);
        person.setName("lin");
        personDao.addPerson(person);
        List<Person> personList=personDao.listPersons();
        for(Person p: personList) {
            System.out.println("Name:"+p.getName());
            System.out.println("Age:"+p.getAge());
        }
    }
}
