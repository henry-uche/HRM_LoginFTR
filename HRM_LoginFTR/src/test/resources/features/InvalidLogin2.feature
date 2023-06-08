
Feature: Login

                      Scenario Outline: Verify that login with invalid credentials returns the correct error message

                        Given I get to the Home page
                        When I enter "<Username>" in the username field
                        And I enter "<Password>" in the password field
                        When I click login button
                        Then I should get the correct "<Errormessage>"

                        Examples:
                        |Username        |Password      |Errormessage         |
                        |garry           |admin123      |Invalid credentials  |
                        |Admin           |Garry33       |Invalid credentials  |
                        |garry           |Garry33       |Invalid credentials  |

