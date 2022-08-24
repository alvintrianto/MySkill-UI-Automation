Feature: Login with TDD

  @TDD @Login
  Scenario Outline: Login
    Given User is on login page
    When User input <username> and <password>
    And User click login button
    Then User verify login <result>

    Examples:
      |username           |password       |result     |
      |standard_user      |secret_sauce   |Passed     |
      #|wrong_user         |secret_sauce   |Failed     |
      #|standard_user      |wrong_password |Failed     |