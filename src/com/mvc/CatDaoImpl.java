package com.mvc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CatDaoImpl  implements ICatDao {
	private static final SessionFactory sessionFactory;
	private static Transaction transaction;
	private  static Session session;

	static {
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(CatDaoImpl.class).buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();                          //打开Session
	}


	@Override
	public void createCat(Cat cat) {
		session=getSession();
		try{
			transaction=session.beginTransaction();
			session.save(cat);
			transaction.commit();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();                     //关闭Session
		}
	}

	@Override
	public Cat findCatByName(String catName) {
		getSession();
		Cat foundCat=new Cat();
		try{
			transaction=session.beginTransaction();
			String sql="select * from  where name='"+catName+"'";
			NativeQuery query=session.createNativeQuery(sql);
			List<Object[]> cats=query.getResultList();
			for(Object[] cat:cats) {
				foundCat.setId((int)cat[0]);
				foundCat.setName((String)cat[1]);
				foundCat.setCreatedDate((Date)cat[2]);
			}
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return foundCat;
	}

	@Override
	public int getCatsCount() {
           return listCats().size();
	}

	@Override
	public List<Cat> listCats() {
		getSession();
		List<Cat> cats=new ArrayList<Cat>();
		try{
			transaction = session.beginTransaction();
			cats= session.createQuery("FROM Cat").list();
//			for (Iterator iterator =
//				 cats.iterator(); iterator.hasNext();){
//				Cat cat = (Cat) iterator.next();
//				System.out.print("id: " + cat.getId());
//				System.out.print("name: " + cat.getName());
//				System.out.println("date: " + cat.getCreatedDate());
//			}
			transaction.commit();

		}catch (HibernateException e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cats;
	}

}
