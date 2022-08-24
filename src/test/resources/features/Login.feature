@All
Feature: Login

  @Test1
  Scenario: Login
    Given User is on login page
    When User fill username and password
    And User click login button
    Then User verify login result

  @Test2
  Scenario: Login invalid Password
    Given User is on login page
    When User fill password but invalid username
    And User click login button
    Then User get error username password not match

