Feature: Pim Users

  Background: login
	Given User is logged in

  Scenario Outline: creating a pim user
	Given I go to PIM page
	When I add a new PIM user: "<firstname>" "<lastname>"
	Then A new user is created in 'Directory' with name: "<firstname>" "<lastname>"

	Examples:
	  | firstname | lastname |
	  | Alberto   | Quack    |
	  | Gerome    | Stilton  |

