Feature: Orange HRM - Login

  @hrmlogin
  Scenario: User login Orange HRM successfully
    Given I open Orange HRM login page
    When I input username and password
    And I click login button
    Then I can login successfully