package com.spring.test.controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.test.dao.IEmployeeDao;
import com.spring.test.pojo.Employee;
import com.spring.test.service.EmployeeService;
import com.spring.test.validation.EmployeeValidation;

@Controller
public class EmployeeController {

	/*
	 * public EmployeeController() {
	 * System.out.println("employee controller object created!!"); }
	 */

	static SessionFactory sf;
	/*
	 * @Autowired Employee e1;
	 */

	@Autowired
	IEmployeeDao empDao;

	@Autowired
	EmployeeService empService;

	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerEmployee(Model m, Employee emp) {

		System.out.println("Preparing pojo object");

		// Validation logic starts here
		EmployeeValidation validation = new EmployeeValidation();

		boolean result = validation.isTextEmpty(emp.getName());
		if (result) {
			m.addAttribute("message", "Name should not be empty!!");
			m.addAttribute("employee", emp);
			return "Register";
		}

		result = validation.isTextEmpty(emp.getEmail());
		if (result) {
			m.addAttribute("message", "Mail Id should not be empty!!");
			m.addAttribute("employee", emp);
			return "Register";
		}

		result = validation.isTextEmpty(emp.getMbl());
		if (result) {
			m.addAttribute("message", "Mobile number should not be empty!!");
			m.addAttribute("employee", emp);
			return "Register";
		}

		validation.isTextEmpty(emp.getPword());
		if (result) {
			m.addAttribute("message", "Password should not be empty!!");
			m.addAttribute("employee", emp);
			return "Register";
		}
		// Validation logic ends here

		try {
			empDao.registerEmployee(emp);

		} catch (ConstraintViolationException e) {
			m.addAttribute("message", " Already registered with this mail id. Please try with other mail id!!");
			return "Register";
		} catch (Exception e) {
			m.addAttribute("message", "Please try after sometime!! Something went wrong!!");
			return "Register";
		}

		System.out.println("EmployeeController :: registerEmployee() method!!");
		/*
		 * System.out.println(empName); System.out.println(empEmail);
		 * System.out.println(empMobile);
		 */
		return "login";

	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginEmployee(Model m, @RequestParam("email") String email, @RequestParam("pword") String pword) {

		String result = empService.loginEmployee(m, email, pword);
		return result;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteEmployee(Model model, @RequestParam("mailId") String email) {
		System.out.println("Entered into deleteEmployee method :: EmployeeController");
		System.out.println(email);
		// database logic starts
		Session session = sf.openSession();
		Query query = session.createQuery("delete from Employee where email=?");
		query.setString(0, email);
		query.executeUpdate();

		// get all employees from database and set to emplist in model object
		Query fetchquery = session.createQuery(" from Employee");
		List<Employee> list = fetchquery.list();

		model.addAttribute("emplist", list);
		session.beginTransaction().commit();
		session.close();
		// database logic ends
		return "details";
	}

	@RequestMapping(value = "/openInEditView", method = RequestMethod.POST)
	public String openEditView(Model model, @RequestParam("mailId") String email) {
		System.out.println(email);
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee where email=?");
		query.setString(0, email);

		// get all employees from database and set to emplist in model object

		List<Employee> list = query.list();

		model.addAttribute("empl", list.get(0));
		session.beginTransaction().commit();
		session.close();
		// database logic ends
		return "editView";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(Model model, Employee emp) {
		Session session = sf.openSession();
		session.update(emp);

		/*
		 * try { session.beginTransaction().commit(); }catch(StaleObjectStateException
		 * e) { model.addAttribute("ErrorMsg",
		 * "The record has been modified by other user, can you plaese take the latest and update on the latest one..."
		 * ); }
		 */

		Query fetchquery = session.createQuery(" from Employee");
		List<Employee> list = fetchquery.list();

		model.addAttribute("emplist", list);
		session.beginTransaction().commit();
		session.close();
		return "details";
	}

	@RequestMapping(value="/goToLoginPage")
	public String goToLoginPage() {
		System.out.println("executing goto loginpage......");
		return "login";
	}

	@RequestMapping(value="/home")
	public String goToHome() {
		System.out.println("executing goToHome page.....");
		return "Profile";
	}
	
	@RequestMapping(value="/goToFailurePage")
	public String goToFailurePage(Model model) {
		model.addAttribute("message", "Invalid credentials!!, Please login with valid credentials...");
		System.out.println("executing failure page....");
		return "login";
	}
}
