package com.paradigma.cucumber.controller.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.cucumber.controller.calculator.rdto.request.CalculatorRQDTO;

@RestController(value = "/calculator")
public class CalculatorController {

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public Integer sumNumbers(@RequestBody CalculatorRQDTO calculatorRQ) {
		return calculatorRQ.getFirstNumber() + calculatorRQ.getSecondNumber();
	}
}
