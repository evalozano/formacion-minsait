package com.paradigma.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;


public class CalculatorTest {

	private Calculator calculator = new Calculator();
	
	@Test
	public void shouldSumTwoNumbers() {
		//given
		String numbers = "2,1";
		
		//when
		String result = calculator.add(numbers);
		
		//then
		Assert.assertEquals("3", result);
	}
	
	@Test
	public void shouldSumOneNumber() {
		//given
		String numbers = "1";
		
		//when
		String result = calculator.add(numbers);
		
		//then
		Assert.assertEquals("1", result);
	}
	
	@Test
	public void shouldReturnEmptyWhenSumIsZero() {
		//given
		String numbers = "0";
		
		//when
		String result = calculator.add(numbers);
		
		//then
		Assert.assertEquals("", result);
	}
}
