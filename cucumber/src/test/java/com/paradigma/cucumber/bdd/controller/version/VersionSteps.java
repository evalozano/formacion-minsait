package com.paradigma.cucumber.bdd.controller.version;

import static com.jayway.restassured.RestAssured.with;

import org.junit.Assert;

import com.jayway.restassured.response.Response;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VersionSteps {

	private Response responseCall;

	@When("^the client calls /version$")
	public void the_client_issues_GET_version() throws Throwable {
		responseCall = with().get("http://localhost:8080/version");

	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
		
		Assert.assertEquals(statusCode, responseCall.getStatusCode());
	}

	@And("^the client receives server version (.+)$")
	public void the_client_receives_server_version_body(String version) throws Throwable {
		Assert.assertEquals(responseCall.getBody().asString(), version);
	}
}
