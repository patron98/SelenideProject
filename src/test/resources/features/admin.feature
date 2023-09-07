Feature: Admin Feature

  Background:
    Given I open the website

  Scenario Outline: create a new user as admin
    # Given User is logged in
    And A PIM user exists with "Marko" "Polo"
    When Admin creates a new user: "<username>"
    Then A new user is created

    And Cleanup PIM user: "Marko" "Polo"
    # And Cleanup Admin user: "Super Mario"
    Examples:
      | username             |
      | Super Mario          |
      | batman               |
      | theUltimateMonster93 |
