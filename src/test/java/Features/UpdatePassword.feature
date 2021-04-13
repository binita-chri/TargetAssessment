#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Smoketest
Feature: Test Update Password and Login

  @UpdatePassword
  Scenario: Verify user is able to update password and login with updated password successfully
    Given I login to the timetracker as an existing user
      | bi007 |
      | test  |
    And I update the Password of the user
      | Test1 |
      | Test1 |
    And I logout from the timetracker
    When I login with the updated timetracker user details
      | bi007 |
      | Test1 |
    Then I am able to login successfully
