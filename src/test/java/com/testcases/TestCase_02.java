package com.testcases;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase_02 {
	@Test
	public void testcase_02() {
		RestAssured.baseURI="https://testvagrant.free.beeceptor.com";
		RequestSpecification req=RestAssured.given();
		Response response=req.request(Method.GET,"/favicon.ico");
		String asString = response.getBody().asString();
		System.out.println(asString);

		List<Object> list1 = response.jsonPath().getList("player.findAll{player->player.role=='Wicket-keeper'}");
		System.out.println(list1.toString());
		System.out.println("No.of Wicket keeper in Team:"+list1.size());
		Assert.assertEquals(list1.size(), 1);
	}
}
