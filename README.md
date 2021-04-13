# TargetAssessment
This assessment/test is about testing Update Password and Update Login (username) functionality. Updated username and password work well for a successful login.
This is a Behaviour Driver Development framework and tests are designed using JUnit, Selenium WebDriver, Cucumber and Java languate.
The structure is like
Feature:: Which contains the feature files and scenarios
Steps: That is glue code/implementation of all the methods to be executed in feature tests
Runner: That contains a runner file to run the test case getting information from Feature tests and definition from Steps

Mentioned scenarios have been covered, however, I have a few more points which I could have implemented to enhance the code and make it more independent:
To check if updated password and login works for a user, if we want to make this test as a part of CI job, we may need it to be running independently multiple times.With current implementation, one time used credentials won't work if the test is run again.
So to overcome that, I would implement a create user with random string every time before running this test case. Update test will get that recently created user only.
For now due to time constraint I have just used @After and @Before annotations which I could expand by utilizing other annotations as well to make it a more precise implementation.
In terms of covering scenarios, I could have added few more negative test cases for Update Password and Login Functionality

Thank you.
