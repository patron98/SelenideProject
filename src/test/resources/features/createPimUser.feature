Feature: Pim Users

  Background: login
    Given User is logged in

  Scenario Outline: creating a pim user
    When I add a new PIM user: "<firstname>" "<lastname>"
    Then A new user is created in 'Directory' with name: "<firstname>" "<lastname>"

    Examples:
      | firstname | lastname |
      | Alberto   | Quack    |

  Scenario Outline: deleting a pim user
    Given A PIM user exists with "<firstname>" "<lastname>"
    When The user gets deleted
    Then The user no longer exists

    Examples:
      | firstname | lastname |
      | Alberto   | Quack    |