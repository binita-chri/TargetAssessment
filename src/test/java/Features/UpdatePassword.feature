#Author: binita.bennet.christian@gmail.com

@Smoketest
Feature: Test Update Password and Login

  @UpdatePassword
  Scenario: Verify user is able to update password and login with updated password successfully
    Given I login to the timetracker as an existing user
      | bi11 |
      | Test1  |
    And I update the Password of the user
      | Test2 |
      | Test2 |
    And I logout from the timetracker
    When I login with the updated timetracker user details
      | bi11 |
      | Test2 |
    Then I am able to login successfully
