package com.hive.test.user_management;

import org.testng.annotations.Test;

import com.suite.abstract_tests.AbstractRestTest;
public class AddUserTest extends AbstractRestTest{

	@Test
	public void verifyAddUserSuccessful() {
		System.out.println(this.given().get("/greeting").asString());
	}
	
	
}
