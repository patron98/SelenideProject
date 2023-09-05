Feature: Pim Users


  Scenario Outline: creating a pim user
    Given User is logged in
    When I add a new PIM user: "<firstname>" "<lastname>"
    Then A new user is created in 'Directory' with name: "<firstname>" "<lastname>"

    Examples:
      | firstname | lastname |
      | Alberto   | Quack    |

