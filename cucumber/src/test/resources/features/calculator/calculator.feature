Feature: Must sum numbers

Scenario Outline: Sum numbers
	Given numbers "<firstNumber>" and "<secondNumber>"
	When I request to calculator	
	Then I receive a HTTP "200"
	And result "<result>"
	Examples:
|firstNumber	|secondNumber|result|
|1			|1		     |2     |
|5			|4		     |9     |
|8			|100		     |108   |
	

