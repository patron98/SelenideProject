package com.patron.stepDefinitions;

import com.patron.service.RecruitmentService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecruitmentStep {

  private final RecruitmentService recruitmentService = new RecruitmentService();

  @When("I create a candidate: {string} {string} {string} {string}")
  public void createCandidate(String firstname, String lastname, String email, String type) {
    recruitmentService.createCandidate(firstname, lastname, email, type);
  }

  @Then("The User is created")
  public void theUserIsCreated() {
    recruitmentService.confirmCandidateCreated();
  }

  @And("Cleanup candidate: {string} {string}")
  public void cleanupCandidate(String firstname, String lastname) {
    recruitmentService.deleteCandidate(firstname, lastname);
  }

  @Given("A candidate exists with: {string} {string} {string} {string}")
  public void aCandidateExistsWith(String firstname, String lastname, String email, String type) {
    recruitmentService.createCandidate(firstname, lastname, email, type);
  }

  @When("I hire the candidate and plan interview with {string}")
  public void iAcceptTheCandidate(String date) {
    recruitmentService.hireCandidate(date);
  }

  @Then("The candidate is hired")
  public void theCandidateIsHired() {
    recruitmentService.checkCandidateStatus();
  }
}
