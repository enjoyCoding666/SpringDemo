package com.jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.*;

/**
 * Created by lenovo on 2017/5/8.
 */
public class PersonDaoImpl extends JdbcDaoSupport implements IPersonDao {
   public void initDatabase() {
        String sql="create table if not exists tb_person (id int auto_increment ,name varchar(255),sex varchar(10),age int ,birthday timestamp,primary key (id))";
        getJdbcTemplate().execute(sql);
   }


    @Override
    public String getPersonName(Integer id) {
       String sql="select name from tb_person where id="+id;
        return (String)getJdbcTemplate().queryForObject(sql,String.class);
    }

    @Override
    public void addPerson(Person person) {
       String sql="insert into tb_person (name,sex,age,birthday) values (?,?,?,?)";
       getJdbcTemplate().update(sql,new Object[]{person.getName(),person.getSex(),person.getAge(),person.getBirthday()});

    }

    @Override
    public int getPersonCount() {
       String sql="select count(*) from tb_person";
        return getJdbcTemplate().queryForObject(sql,Integer.class);
    }

    @Override
    public List<Person> listPersons() {
        String sql="select id,name,sex,age,birthday from tb_person";
        List<Map<String,Object>> list=getJdbcTemplate().queryForList(sql);
        List<Person> personList=new ArrayList<Person>();
        for(Map<String,Object> row : list) {
            Person person=new Person();
            person.setId((Integer)row.get("id"));
            person.setAge((Integer)row.get("age"));
            person.setSex((String) row.get("sex"));
            person.setBirthday((Date) row.get("birthday"));
            person.setName((String)row.get("name"));
            personList.add(person);
        }
        return personList;
    }
}
