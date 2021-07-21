package com.spring.test.validation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.spring.test.pojo.Employee;

public class EmployeeValidation {
	// cntrl + shift + o -> to remove unused imports
	/**
	 * This method returns True if the text is empty
	 * 			   returns False if the text is not empty
	 * @param text
	 * @return
	 */
	public boolean isTextEmpty(String text) {
		if(text == null || text.isEmpty()) {
			return true;
		}
		return false;
	}
}
