Feature: Admin Feature

  Background:
    Given I open the website

  Scenario: create a new user as admin
    # Given User is logged in
    And A PIM user exists with "Marko" "Polo"
    When Admin creates a new user: "Super Mario"
    Then A new user is created

    And Cleanup PIM user: "Marko" "Polo"
    And Cleanup Admin user: "Super Mario"
