Feature: Pim Users

  Background:
    Given I open the website

  Scenario: creating a pim user
    Given User is logged in
    When I add a new PIM user: "Alberto" "Quack"
    Then A new user is created in 'Directory' with name: "Alberto" "Quack"

    And Cleanup PIM user: "Alberto" "Quack"

  Scenario: deleting a pim user
    Given A PIM user exists with "Marko" "Polo"
    When The user gets deleted "Marko" "Polo"
    Then The user no longer exists
