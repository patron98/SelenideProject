Feature: Pim Users

  Background:
    Given I open the website

  Scenario Outline: creating a pim user
    Given User is logged in
    When I add a new PIM user: "<firstname>" "<lastname>"
    Then A new user is created in 'Directory' with name: "<firstname>" "<lastname>"

    And Cleanup user: "<firstname>" "<lastname>"

    Examples:
      | firstname | lastname |
      | Alberto   | Quack    |

  Scenario Outline: deleting a pim user
    Given A PIM user exists with "<firstname>" "<lastname>"
    When The user gets deleted "<firstname>" "<lastname>"
    Then The user no longer exists

    Examples:
      | firstname | lastname |
      | Marko     | Polo     |