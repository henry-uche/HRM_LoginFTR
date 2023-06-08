
Feature: Login

  Scenario: Verify that User with Invalid credentials should not Login successfully

    Given I navigates to the home Page
    When I enter an invalid  username
    And I enter an invalid password
    When I hit on the login button
    Then I should not be logged in successfully