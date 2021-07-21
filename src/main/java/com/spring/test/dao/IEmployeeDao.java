package com.spring.test.dao;

import java.util.List;

import com.spring.test.pojo.Employee;

public interface IEmployeeDao {
	public void registerEmployee(Employee emp);
	public List<Employee> loginEmployee(String email, String pword);
}
