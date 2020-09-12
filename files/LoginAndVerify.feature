#Author: vinesh.c@brillio.com
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
@tag
Feature: Login into salesforce page
 

  @tag1
  Scenario: Login into salesforce application 
    Given Navigate to Salesforce Login URL
    When Enter the "username" and "password" 
    Then Click on the Login button
     And Verify the Logged in user
     And Logged from the application

