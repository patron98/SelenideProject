package com.patron.stepDefinitions;

import com.patron.service.Service;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMStep {

    private final Service service = new Service();

    @Given("User is logged in")
    public void userIsLoggedIn() {
        service.openPage();
        service.userLogin();
    }

    @Given("I go to PIM page")
    public void iSearchFor() {
        service.goToPimPage();
    }

    @When("I add a new PIM user: {string} {string}")
    public void iAddANewPIMUser(String firstname, String lastname) {
        service.addPIMUser(firstname, lastname);
    }

    @Then("A new user is created in 'Directory' with name: {string} {string}")
    public void aNewUserIsCreatedWithName(String firstname, String lastname) {
        service.checkCreatedPIMUserInDirectory(firstname, lastname);
    }
}
