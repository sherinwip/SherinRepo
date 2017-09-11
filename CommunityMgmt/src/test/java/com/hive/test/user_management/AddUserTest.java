package com.hive.test.user_management;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.suite.abstract_tests.AbstractRestTest;

import io.restassured.response.Response;
public class AddUserTest extends AbstractRestTest{

	@Test
	public void verifyAddUserSuccessful() {
		Response response = this.given().get("/users?id=10&username=vaibhav");
		System.out.println("********** Response time is - "+response.getTimeIn(TimeUnit.MILLISECONDS));
		Assert.assertEquals(405,response.getStatusCode());
		Assert.assertEquals("HTTP/1.1 405 ",response.getStatusLine());
		Assert.assertTrue("Response time is - "+response.getTimeIn(TimeUnit.MILLISECONDS), response.getTimeIn(TimeUnit.MILLISECONDS)<1000);
	}
	
	
}
