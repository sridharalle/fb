package com.spring.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.test.dao.IEmployeeDao;
import com.spring.test.pojo.Employee;
import com.spring.test.validation.EmployeeValidation;

public class EmployeeService {
	
	public EmployeeService() {
		System.out.println("EmployeeService object created");
	}

	@Autowired
	IEmployeeDao empDao;

	@Autowired
	Employee e1;

	@Autowired
	Employee e2;

	@Autowired
	Employee e3;

	//Employee e4 = new Employee();

	public String loginEmployee(Model m, String email, String pword) {

		/*System.out.println(e1.getName() + "-" + e1.getMbl() + "-" + e1.getEmail() + "-" + e1.getPword() + "-"
				+ e1.getPport().getPptId() + "-" + e1.getPport().getIssueCity());
		System.out.println(e2.getName() + "-" + e2.getMbl() + "-" + e2.getEmail() + "-" + e2.getPword() + "-"
				+ e2.getPport().getPptId() + "-" + e2.getPport().getIssueCity());
		System.out.println(e3.getName() + "-" + e3.getMbl() + "-" + e3.getEmail() + "-" + e3.getPword() + "-"
				+ e3.getPport().getPptId() + "-" + e3.getPport().getIssueCity());
		//System.out.println(e4);

		System.out.println("-------ioc testing here --------");
		e1.setName("Ramu");
		e1.setPword("5566");
		e1.setEmail("ramu@gmail.com");
		e1.getPport().setPptId(11234);
		e1.getPport().setIssueCity("Hyderabad");

		System.out.println(e1.getName() + "-" + e1.getMbl() + "-" + e1.getEmail() + "-" + e1.getPword() + "-"
				+ e1.getPport().getPptId() + "-" + e1.getPport().getIssueCity());
		System.out.println(e2.getName() + "-" + e2.getMbl() + "-" + e2.getEmail() + "-" + e2.getPword() + "-"
				+ e2.getPport().getPptId() + "-" + e2.getPport().getIssueCity());
		System.out.println(e3.getName() + "-" + e3.getMbl() + "-" + e3.getEmail() + "-" + e3.getPword() + "-"
				+ e3.getPport().getPptId() + "-" + e3.getPport().getIssueCity());
		//System.out.println(e4);

		e2.setName("Raju");
		e2.setPword("6655");
		e2.setEmail("raju@gmail.com");
		e2.getPport().setPptId(22456);
		e2.getPport().setIssueCity("Chennai");

		System.out.println(e1.getName() + "-" + e1.getMbl() + "-" + e1.getEmail() + "-" + e1.getPword() + "-"
				+ e1.getPport().getPptId() + "-" + e1.getPport().getIssueCity());
		System.out.println(e2.getName() + "-" + e2.getMbl() + "-" + e2.getEmail() + "-" + e2.getPword() + "-"
				+ e2.getPport().getPptId() + "-" + e2.getPport().getIssueCity());
		System.out.println(e3.getName() + "-" + e3.getMbl() + "-" + e3.getEmail() + "-" + e3.getPword() + "-"
				+ e3.getPport().getPptId() + "-" + e3.getPport().getIssueCity());
		//System.out.println(e4);

		e3.setName("Virat");

		System.out.println(e1.getName() + "-" + e1.getMbl() + "-" + e1.getEmail() + "-" + e1.getPword() + "-"
				+ e1.getPport().getPptId() + "-" + e1.getPport().getIssueCity());
		System.out.println(e2.getName() + "-" + e2.getMbl() + "-" + e2.getEmail() + "-" + e2.getPword() + "-"
				+ e2.getPport().getPptId() + "-" + e2.getPport().getIssueCity());
		System.out.println(e3.getName() + "-" + e3.getMbl() + "-" + e3.getEmail() + "-" + e3.getPword() + "-"
				+ e3.getPport().getPptId() + "-" + e3.getPport().getIssueCity());
*/		System.out.println("------ioc testing here------");

		System.out.println("Employee email is:" + email);
		System.out.println("Employee password is:" + pword);

		// Validation logic
		EmployeeValidation validation = new EmployeeValidation();
		boolean result = validation.isTextEmpty(email);
		if (result) {
			m.addAttribute("message", "Mail Id should not be empty!!");
			return "login";
		}
		result = validation.isTextEmpty(pword);
		if (result) {
			m.addAttribute("message", "Password should not be empty!!");
			return "login";
		}

		// database logic starts here

		List<Employee> list = empDao.loginEmployee(email, pword);

		if (list.isEmpty()) {
			System.out.println("list is empty!! entered invalid credentials..");
			m.addAttribute("message", "Entered invalid credentials.Please try again!");
			return "login";
		} else {
			System.out.println("Entered valid credentials");
			/*
			 * //list iterate for (Employee emp : list) {
			 * System.out.println("Employee details are...");
			 * System.out.println(emp.getEmail()); System.out.println(emp.getName());
			 * System.out.println(emp.getEmail() +"-------"+ emp.getName());
			 * 
			 * }
			 */
			m.addAttribute("userName", list.get(0).getName());
			return "Profile";
		}

		// database logic ends here

	}
}
