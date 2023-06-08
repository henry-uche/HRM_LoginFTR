Feature: leave Menu

  Scenario: Validate that the leave menu is active and navigates correctly

    Given I am logged in successfully
    When  I click on the Leave menu
    Then  I should be navigated to the Leave list page