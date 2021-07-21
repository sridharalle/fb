package com.spring.test.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.spring.test.dao.IEmployeeDao;
import com.spring.test.pojo.Employee;

public class EmployeeDaoJdbcImpl implements IEmployeeDao{
	
	public EmployeeDaoJdbcImpl() {
		System.out.println("EmployeeDaoJdbc object created");
	}

	public void registerEmployee(Employee emp) {
		System.out.println("entered into registerEmployee method from EmployeeDaoJdbcImpl");

		System.out.println("----jdbc logic comes here----");

		System.out.println("exit from registerEmployee method from EmployeeDaoJdbcImpl");
	}

	public List<Employee> loginEmployee(String email, String pword) {
		System.out.println("entered into registerEmployee method from EmployeeDaoJdbcImpl");

		System.out.println("----jdbc logic comes here----");

		System.out.println("exit from registerEmployee method from EmployeeDaoJdbcImpl");

		return new ArrayList<Employee>();
	}

}
