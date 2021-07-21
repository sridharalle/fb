package com.spring.test.dao;

public class TestIocDao {
	
	//static TestIocDao dao = null;
	private TestIocDao() {
		System.out.println("test dao object created");
	}

	/*public static TestIocDao getInstance() {
		if(dao== null) {
			dao= new TestIocDao();
			return dao;
		}else {
			return dao;
		}
	}*/
	public void triggered() {
		System.out.println("Database logic comes here");
		System.out.println("delete operation triggered");
	}
}
