package com.paradigma.cucumber.bdd.controller.ping;

import static com.jayway.restassured.RestAssured.with;

import org.junit.Assert;

import com.jayway.restassured.response.Response;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PingSteps {

	private Response responseCall;
	@When("^the client calls /ping$")
	public void the_client_calls_ping() throws Exception {
		responseCall = with().get("http://localhost:8080/ping");

	}
	
	@Then("^the client receives status \"([^\"]*)\"$")
	public void the_client_receives_status(int statusCode) throws Exception {
		Assert.assertEquals(statusCode, responseCall.getStatusCode());
	}

	@Then("^the client receives message \"([^\"]*)\"$")
	public void the_client_receives_message(String message) throws Exception {
		Assert.assertEquals(responseCall.getBody().asString(), message);
	}
}
