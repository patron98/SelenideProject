package com.patron.stepDefinitions;

import com.patron.service.Service;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMStep {

    private final Service service = new Service();

    @Given("User is logged in")
    public void userIsLoggedIn() {
        service.userLogin();
    }

    @When("I add a new PIM user: {string} {string}")
    public void iAddANewPIMUser(String firstname, String lastname) {
        service.addPIMUser(firstname, lastname);
    }

    @Then("A new user is created in 'Directory' with name: {string} {string}")
    public void aNewUserIsCreatedWithName(String firstname, String lastname) {
        service.checkCreatedPIMUserInDirectory(firstname, lastname);
    }

    @Given("A PIM user exists with {string} {string}")
    public void aPIMUserExistsWith(String firstname, String lastname) {
        service.addPIMUser(firstname, lastname);
    }

    @When("The user gets deleted {string} {string}")
    public void theUserGetsDeleted(String firstname, String lastname) {
        service.deletePIMUser(firstname, lastname);
    }

    @Then("The user no longer exists")
    public void theUserNoLongerExists() {
        service.checkDeletedPIMUser();
    }

    @And("Cleanup user: {string} {string}")
    public void cleanupUser(String firstname, String lastname) {
        service.deletePIMUser(firstname, lastname);
        service.checkDeletedPIMUser();
    }
}
