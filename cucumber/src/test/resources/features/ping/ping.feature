Feature: the ping can be retrieved
  
  Scenario: client makes call to GET ping
    When the client calls /ping
    Then the client receives status "200"
    And the client receives message "pong"