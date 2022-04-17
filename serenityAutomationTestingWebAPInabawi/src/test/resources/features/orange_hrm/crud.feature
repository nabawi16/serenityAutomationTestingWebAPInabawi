@all @hrmcrud
Feature: Orange HRM - CRUD Employee Data

  Background:
    Given I open Orange HRM login page
    And I input username and password
    And I click login button
    And I access employee list

  @hrmcreate
  Scenario: User add Orange HRM employee successfully
    When I add new employee with required field only
    Then I can see my Personal Details

  @hrmread
  Scenario: User read Orange HRM employee successfully
    And I can see new employee list result

  @hrmupdate
  Scenario: User update Orange HRM employee successfully
    When I search for new employee
    When I update new employee's middle name
    Then I can see the Personal Details has changed

  @hrmdelete
  Scenario: User delete Orange HRM employee successfully
    And I search for new employee
    And I delete new employee
    And I can't see delete employee on list