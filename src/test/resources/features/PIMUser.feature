# @Login
Feature: Pim Users

  Background:
    Given I open the website

  Scenario: login
    Given User is logged in

  Scenario Outline: creating and cleaning up PIM users
    When I add a new PIM user: "<FirstName>" "<LastName>"
    Then A new user is created in 'Directory' with name: "<FirstName>" "<LastName>"

    And Cleanup PIM user: "<FirstName>" "<LastName>"

    Examples:
      | FirstName | LastName |
      | Alberto   | Quack    |
      | Alice     | Smith    |
      | Marko     | Polo     |

  Scenario Outline: deleting PIM users
    Given A PIM user exists with "<FirstName>" "<LastName>"
    When The user gets deleted "<FirstName>" "<LastName>"
    Then The user no longer exists

    Examples:
      | FirstName | LastName |
      | Marko     | Polo     |
      | Jane      | Doe      |
      | Mary      | Johnson  |

