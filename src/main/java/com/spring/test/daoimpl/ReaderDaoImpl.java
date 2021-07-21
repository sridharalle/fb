package com.spring.test.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.test.pojo.Employee;

public class ReaderDaoImpl {
	
	static SessionFactory sf;
	static{
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		 sf = cfg.buildSessionFactory();
	}

	public List<Employee> getEmployees() {
		
		System.out.println("entered into ReaderDaoImpl");
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee");
		
		List<Employee> list = query.list();
		System.out.println("exit from ReaderDaoImpl");
		return list;
	}
}
