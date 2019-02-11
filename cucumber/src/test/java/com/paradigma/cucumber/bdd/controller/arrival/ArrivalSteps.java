package com.paradigma.cucumber.bdd.controller.arrival;

import static com.jayway.restassured.RestAssured.with;

import java.util.List;

import org.junit.Assert;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.paradigma.cucumber.controller.arrival.ArrivalController;
import com.paradigma.cucumber.controller.arrival.rdto.response.ArrivalRSDTO;
import com.paradigma.cucumber.controller.calculator.rdto.request.CalculatorRQDTO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ArrivalSteps {

	private Response responseCall;

	@When("^I request to arrival$")
	public void i_request_to_arrival() throws Exception {
		responseCall = with().get("http://localhost:8080/arrival/all");
	}
	
	@Then("^I receive a HTTP code \"([^\"]*)\"$")
	public void i_receive_a_HTTP_code(int httpCode) throws Exception {
		Assert.assertEquals(httpCode, responseCall.getStatusCode());
	}

	@Then("^arrival list$")
	public void arrival_list() throws Exception {
		Assert.assertNotEquals(responseCall.getBody().asString(), null);
	}
	
	@When("^I request to arrival by (.*)$")
	public void i_request_to_arrival_by(String arg1) throws Exception {
	   
	}
	
	@Then("^I receive a HTTP message \"([^\"]*)\"$")
	public void i_receive_a_HTTP_message(String arg1) throws Exception {
	   
	}
	
	@Then("^arrival not null$")
	public void arrival_not_null() throws Exception {
	
	}



}
