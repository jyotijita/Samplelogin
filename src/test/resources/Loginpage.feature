@login-feature
Feature: Login Functionality

@PositiveScenario
  Scenario: As a User I want to login to a website so that I can access my account
    Given I am on the Linkedin login page
    When I enter valid credentials
    And  I Click on signin button
    Then I should be logged in successfully
    
@WrongUsernameScenario
Scenario: As a User I shouldn't be able to login If I enter wrong username 
    Given I am on the Linkedin login page
    When I enter wrong username and  correct password credentials
    And  I Click on signin button
    Then I should be able to see and validate the error message for the username field

@WrongPasswordScenario 
Scenario: As a User I shouldn't be able to login If I enter wrong password 
    Given I am on the Linkedin login page
    When I enter correct username and  wrong password credentials
    And  I Click on signin button
    Then I should be able to see and validate the error message for password field
