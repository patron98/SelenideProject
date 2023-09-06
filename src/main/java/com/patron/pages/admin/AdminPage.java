package com.patron.pages.admin;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.modals.DeleteModal;
import org.openqa.selenium.By;

public class AdminPage {

  private final SelenideElement addButton = $x("//button[contains(.,'Add')]");
  private final SelenideElement searchUserInput = $x(
      "//label[text()='Username']/following::input[1]");
  private final SelenideElement searchButton = $("button[type='submit']");
  private final SelenideElement searchResult = $("div.oxd-table-row", 1);
  private final By deleteButton = byCssSelector("i.oxd-icon.bi-trash");
  private final SelenideElement deleteConfirmation = $("p.oxd-text--toast-message");

  public CreateAdminUserPage goToCreateNewUser() {
    addButton.click();
    return new CreateAdminUserPage();
  }

  public DeleteModal deleteUser(String username) {
    searchUserInput.sendKeys(username);
    searchButton.click();
    searchResult.shouldHave(text(username));
    searchResult.find(deleteButton).click();
    return new DeleteModal();
  }

  public void checkDeletedUser() {
    deleteConfirmation.shouldHave(text("Successfully Deleted"));
  }
}
