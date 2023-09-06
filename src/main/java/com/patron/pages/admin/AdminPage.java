package com.patron.pages.admin;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class AdminPage {

  private final SelenideElement addButton = $x("//button[contains(.,'Add')]");

  public CreateAdminUserPage goToCreateNewUser() {
    addButton.click();
    return new CreateAdminUserPage();
  }
}
