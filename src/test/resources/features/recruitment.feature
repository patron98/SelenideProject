@Recruitment
Feature: Recruitment Feature

  Background:
	Given I open the website

  Scenario: login
	Given User is logged in

  Scenario Outline: Creating new candidate
	When I create a candidate: "<firstname>" "<lastname>" "<email>" "<type>"
	Then The User is created

	And Cleanup candidate: "<firstname>" "<lastname>"
	Examples:
	  | firstname | lastname | email                     | type                     |
	  | Steve     | Johnson  | steve.johnson@example.com | Associate IT Manager     |
	  | Dirk      | Steven   | alice.smith@example.com   | Junior Account Assistant |
	  | John      | Doe      | john.doe@example.com      | Senior QA Lead           |

  Scenario Outline: Hire candidate
	Given A PIM user exists with "Marko" "Polo"
	And A vacancy exists from "<type>" with manager "Marko Polo"
	And A candidate exists with: "<firstname>" "<lastname>" "<email>" "<type>"
	When I hire the candidate and plan interview with "<date>"
	Then The candidate is hired

	And Cleanup PIM user: "Marko" "Polo"
	And Cleanup candidate: "<firstname>" "<lastname>"
	And Cleanup vacancy: "<type>"
	Examples:
	  | firstname | lastname | email                     | type                     | date       |
	  | Steve     | Johnson  | steve.johnson@example.com | Associate IT Manager     | 2023-11-20 |
	  | Dirk      | Steven   | alice.smith@example.com   | Junior Account Assistant | 2023-12-30 |
	  | John      | Doe      | john.doe@example.com      | Senior QA Lead           | 2024-01-12 |