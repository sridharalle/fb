package com.spring.test.daoimpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import com.spring.test.dao.IEmployeeDao;
import com.spring.test.pojo.Employee;

//@Repository
public class EmployeeDaoImpl implements IEmployeeDao{
	
	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl object created");
	}

	static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}

	public void registerEmployee(Employee emp) {
		System.out.println("entered into registerEmployee method from EmployeeDaoImpl");
		Session session = sf.openSession();
		session.save(emp);
		session.beginTransaction().commit();
		session.close();
		System.out.println("exit from registerEmployee method from EmployeeDaoImpl");
	}

	public List<Employee> loginEmployee(String email, String pword) {
		System.out.println("entered into loginEmployee method from EmployeeDaoImpl");
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee where email= ? AND pword = ?");
		query.setString(0, email);
		query.setString(1, pword);

		List<Employee> list = query.list();
		System.out.println("exit from loginEmployee method from EmployeeDaoImpl");
		return list;
	}
}
