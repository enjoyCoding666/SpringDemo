package com.dao;

import java.util.List;

/**
 * Created by lenovo on 2017/5/8.
 */
public interface IPersonDao {
    public String getPersonName(Integer id);
    public void addPerson(Person person);
    public int getPersonCount();
    public List<Person> listPersons();
}
