package com.patron.stepDefinitions;

import com.patron.service.Service;
import io.cucumber.java.en.Given;

public class PIMStep {

    private final Service service = new Service();

    @Given("User is logged in")
    public void userIsLoggedIn() {
        service.openPage();
        service.userLogin();
    }

    @Given("I search for {string}")
    public void iSearchFor(String searchInput) {
        service.search(searchInput);
    }
}
