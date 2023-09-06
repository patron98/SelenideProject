package com.patron.stepDefinitions;

import com.patron.service.CommonService;
import com.patron.service.PIMService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMStep {

  private final PIMService pimService = new PIMService();
  private final CommonService commonService = new CommonService();

  @Given("User is logged in")
  public void userIsLoggedIn() {
    commonService.userLogin();
  }

  @When("I add a new PIM user: {string} {string}")
  public void iAddANewPIMUser(String firstname, String lastname) {
    pimService.addPIMUser(firstname, lastname);
  }

  @Then("A new user is created in 'Directory' with name: {string} {string}")
  public void aNewUserIsCreatedWithName(String firstname, String lastname) {
    pimService.checkCreatedPIMUserInDirectory(firstname, lastname);
  }

  @Given("A PIM user exists with {string} {string}")
  public void aPIMUserExistsWith(String firstname, String lastname) {
    pimService.addPIMUser(firstname, lastname);
  }

  @When("The user gets deleted {string} {string}")
  public void theUserGetsDeleted(String firstname, String lastname) {
    pimService.deletePIMUser(firstname, lastname);
  }

  @Then("The user no longer exists")
  public void theUserNoLongerExists() {
    pimService.checkDeletedPIMUser();
  }

  @And("Cleanup PIM user: {string} {string}")
  public void cleanupUser(String firstname, String lastname) {
    pimService.deletePIMUser(firstname, lastname);
    pimService.checkDeletedPIMUser();
  }
}
