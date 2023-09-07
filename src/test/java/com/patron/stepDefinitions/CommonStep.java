package com.patron.stepDefinitions;

import com.patron.service.CommonService;
import io.cucumber.java.en.Given;

public class CommonStep {

  private final CommonService commonService = new CommonService();

  @Given("I open the website")
  public void iOpenTheWebsite() {
    commonService.openPage();
  }

  @Given("User is logged in")
  public void userIsLoggedIn() {
    commonService.userLogin();
  }
}
