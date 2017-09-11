package com.hive.test.user_management;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
public class AddUserTest extends RestAssured{

	@Test
	public void verifyAddUserSuccessful() {
		System.out.println(this.given().get("http://localhost:8080/greeting").asString());
	}
	
	
}
