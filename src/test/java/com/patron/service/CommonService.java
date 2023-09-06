package com.patron.service;

import static com.codeborne.selenide.Selenide.open;

import com.patron.pages.LoginPage;

public class CommonService {

  private final static String url = "https://opensource-demo.orangehrmlive.com/";

  public void openPage() {
    open(url);
  }

  public void userLogin() {
    new LoginPage().login();
  }
}
