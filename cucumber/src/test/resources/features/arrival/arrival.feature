Feature: Must sum numbers

Scenario: Get all arrivals
	When I request to arrival	
	Then I receive a HTTP code "200"
	And arrival list
	

Scenario Outline: Get by id
	When I request to arrival by <"id">	
	Then I receive a HTTP message "<http>"
	And arrival not null
	Examples:
|id	|http|
|1	|200	 |
|5	|404	 |
	