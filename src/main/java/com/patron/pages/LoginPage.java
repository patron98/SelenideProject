package com.patron.pages;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.dashboard.Dashboard;

public class LoginPage {

  public final SelenideElement usernameInput = $(byName("username"));
  public final SelenideElement passwordInput = $(byName("password"));
  public final SelenideElement submit = $("button");

  public Dashboard login() {
    usernameInput.sendKeys("Admin");
    passwordInput.sendKeys("admin123");
    submit.click();
    return new Dashboard();
  }
}
