Feature: Login Functionality for AutomationExercise Website

    As a user of AutomationExercise Website
    I want to be able to log in with my account credentials
    So that I can place an order/change account information/etc

    Background:
      Given I am on the AutomationExercise login page

    Scenario: Successful login with valid credentials
      Given I have entered a valid email and password
      When I click on the login button
      Then I should be logged in successfully

    Scenario Outline: Unsuccessful login with invalid or empty credentials
      Given I have entered invalid "<email>" and "<password>"
      When I click on the login button
      Then I should see an error message "<errormessage>"

      Examples:
      | email           | password        | errormessage
      | invalid@a.com   | invalidpassword | Invalid credentials
      | valid@a.com     | invalidpassword | Invalid credentials
      | invalid@a.com   | validpassword   | Invalid credentials