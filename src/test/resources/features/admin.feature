Feature: Admin Feature

  Background:
    Given I open the website

  Scenario Outline: create a new user as admin
    Given User is logged in
    When Admin creates a new user: "<firstname>" "<lastname>"
    Then A new user is created in 'user management' with name: "<firstname>" "<lastname>"

    Examples:
      | firstname | lastname |
      | Mario     | Kart     |