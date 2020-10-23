Feature: Application Login

  Scenario Outline: Positive test validation
    Given Initialize the browser with chrome
    And Navigate to the "https://rahulshettyacademy.com/" Site
    And Click on Login button
    When User enters <username> and <password> and logs in
    Then Verify that user is successfully logged in
    And Close browser

    Examples:
      | username      | password |
      | test@nail.com | qwerty   |
      | bla@mail.com  | newPas   |
