package com.spring.test.controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.test.daoimpl.ReaderDaoImpl;
import com.spring.test.pojo.Employee;

@Controller
public class ReaderController {
	
	static SessionFactory sf;
	static{
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		 sf = cfg.buildSessionFactory();
	}
	
	@RequestMapping(value= "/getAllEmployees")
	public String getEmployees(Model model) {
		
		System.out.println("Entered into getEmployees :: ReaderController");
		//database logic starts here
		ReaderDaoImpl dao = new ReaderDaoImpl();
		List<Employee> list = dao.getEmployees();
		
		for (Employee emp : list) {
			System.out.println(emp.getEmail());
			System.out.println(emp.getName());
		}
		model.addAttribute("emplist", list);
		
		//database logic ends here
		return "details";
		
	}

}
