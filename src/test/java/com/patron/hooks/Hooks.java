package com.patron.hooks;

import com.patron.service.CommonService;
import io.cucumber.java.Before;

public class Hooks {

  protected static boolean loggedIn = false;

  @Before("@Login") // Only run for scenarios tagged with @Login
  public void loginIfNeeded() {
    CommonService commonService = new CommonService();
    commonService.openPage();
    if (!loggedIn) {
      commonService.userLogin();
      loggedIn = true;
    }
  }
}
