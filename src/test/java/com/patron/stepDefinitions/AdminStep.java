package com.patron.stepDefinitions;

import com.patron.service.AdminService;
import io.cucumber.java.en.When;

public class AdminStep {

    private final AdminService adminService = new AdminService();
    @When("Admin creates a new user: {string} {string}")
    public void adminCreatesUser(String firtname, String lastname){
        adminService.createNewUser(firtname, lastname);
    }
}
