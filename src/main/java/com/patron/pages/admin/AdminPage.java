package com.patron.pages.admin;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.modals.DeleteModal;

public class AdminPage {

  private final SelenideElement addButton = $x("//button[contains(.,'Add')]");
  private final SelenideElement searchUserInput = $x(
      "//label[text()='Username']/following::input[1]");
  private final SelenideElement searchButton = $("button[type='submit']");
  private final SelenideElement searchResult = $("div.oxd-table-row", 1);
  private final SelenideElement deleteConfirmation = $("p.oxd-text--toast-message");

  public CreateAdminUserPage goToCreateNewUser() {
    addButton.click();
    return new CreateAdminUserPage();
  }

  public DeleteModal deleteUser(String username) {
    searchUserInput.sendKeys(username);
    searchButton.click();
    searchResult.shouldHave(text(username));
    return new DeleteModal();
  }

  public void checkDeletedUser() {
    deleteConfirmation.shouldHave(text("Successfully Deleted"));
  }
}
