package com.paradigma.cucumber.bdd.controller.calculator;

import static com.jayway.restassured.RestAssured.with;

import org.junit.Assert;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.paradigma.cucumber.controller.calculator.rdto.request.CalculatorRQDTO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorSteps {

	private Response responseCall;

	private CalculatorRQDTO calculatorRQ;

	@Given("^numbers \"([^\"]*)\" and \"([^\"]*)\"$")
	public void numbers_and(Integer firstNumber, Integer secondNumber) throws Exception {
		calculatorRQ = new CalculatorRQDTO();
		calculatorRQ.setFirstNumber(firstNumber);
		calculatorRQ.setSecondNumber(secondNumber);
	}

	@When("^I request to calculator$")
	public void i_request_to_calculator() throws Exception {
		responseCall = with().body(calculatorRQ).contentType(ContentType.JSON).post("http://localhost:8080/calculator");

	}

	@Then("^I receive a HTTP \"([^\"]*)\"$")
	public void i_receive_a_HTTP(Integer statusCode) throws Exception {
		Assert.assertEquals(statusCode.intValue(), responseCall.getStatusCode());

	}

	@Then("^result \"([^\"]*)\"$")
	public void result(Integer result) throws Exception {
		Assert.assertEquals(result, Integer.valueOf(responseCall.getBody().asString()));
	}

}
