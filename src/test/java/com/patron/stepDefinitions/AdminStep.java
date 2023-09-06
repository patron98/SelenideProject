package com.patron.stepDefinitions;

import com.patron.service.AdminService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminStep {

  private final AdminService adminService = new AdminService();

  @When("Admin creates a new user: {string}")
  public void adminCreatesUser(String username) {
    adminService.createNewUser(username);
  }

  @Then("A new user is created")
  public void aNewUserIsCreated() {
    adminService.confirmCreatedUser();
  }

  @And("Cleanup Admin user: {string}")
  public void cleanupAdminUser(String username) {
    adminService.deleteAdminUser(username);
    adminService.confirmDeletedUser();
  }
}
