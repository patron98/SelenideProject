package com.patron.pages.pim;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.modals.DeleteModal;
import java.util.function.Function;
import org.openqa.selenium.By;

public class PIMPage {

  private final SelenideElement addEmployeeLink = $(byText("Add Employee"));
  private final SelenideElement employeeNameInput = $(
      byXpath("//label[text()='Employee Name']/following::input"));
  private final SelenideElement searchButton = $("button[type='submit']");
  private final SelenideElement searchResult = $("div.oxd-table-row", 1);
  private final By deleteButton = byCssSelector("i.oxd-icon.bi-trash");
  private final SelenideElement deleteConfirmation = $("p.oxd-text--toast-message");
  private final Function<String, SelenideElement> autocomplete = name ->
      $(byText(name));

  public AddPIMUserPage goToAddPage() {
    addEmployeeLink.click();
    return new AddPIMUserPage();
  }

  public PIMPage searchPIMUser(String firstname, String lastname) {
    employeeNameInput.sendKeys(firstname);
    autocomplete.apply(firstname + " " + lastname).click();
    searchButton.click();
    return this;
  }

  public DeleteModal deletePIMUser(String firstname, String lastname) {
    searchResult.shouldHave(text(firstname));
    searchResult.shouldHave(text(lastname));
    searchResult.find(deleteButton).click();
    return new DeleteModal();
  }

  public void confirmDeletePIMUser() {
    deleteConfirmation.shouldHave(text("Successfully Deleted"));
  }
}
