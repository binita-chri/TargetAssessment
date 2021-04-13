@SmokeTest
Feature: Test updating login username

@UdpateLogin
Scenario:	Verify user is able to update login username and updated login works well for successful login

	Given I login to the timetracker as an existing user
	|bi001|
	|Test1|
	And I update the Login of the user
	|bi002|

	And I logout from the timetracker
	When I login with the updated timetracker user details
	|bi002|
	|Test1|
	Then I am able to login successfully