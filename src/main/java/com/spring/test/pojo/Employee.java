package com.spring.test.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Employee")
public class Employee {
	private String name;

	@Id
	private String email;

	private String mbl;

	private String pword;
	
	private String role="ROLE_USER";
	/*
	 * @Version private Long version;
	 */
	/*
	 * @Autowired private Passport pport;
	 */

	public Employee() {
		System.out.println("default no arguement constructor");
	}

	/*
	 * public Employee(Passport p) { this.pport = p;
	 * System.out.println("passport objected injected!!"); }
	 */

	public Employee(String name, String salary) {
		System.out.println("Name and Salarycame from constructor injection:-" + name + "-" + salary);
		System.out.println("Employee object created");
	}

	/*
	 * public Passport getPport() { return pport; }
	 * 
	 * public void setPport(Passport pport) { this.pport = pport; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMbl() {
		return mbl;
	}

	public void setMbl(String mbl) {
		this.mbl = mbl;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
