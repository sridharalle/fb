package com.spring.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.test.dao.TestIocDao;

@Controller
public class TestIocController {

	@Autowired
	TestIocDao dao;

	@Autowired
	TestIocDao dao2;

	@Autowired
	TestIocDao dao3;

	@RequestMapping(value = "/testCon")
	public String triggered() {
		System.out.println("--------Test Ioc Controller-----");

		dao.triggered();
		return "Register";
	}
}
