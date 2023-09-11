package com.patron.pages.pim;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

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

  public AddPIMUserPage goToAddPimUser() {
    addEmployeeLink.shouldBe(visible, ofSeconds(5)).click();
    return new AddPIMUserPage();
  }

  public PIMPage searchPimUser(String firstname, String lastname) {
    employeeNameInput.shouldBe(visible, ofSeconds(5)).sendKeys(firstname);
    autocomplete.apply(firstname + " " + lastname).click();
    searchButton.click();
    return this;
  }

  public DeleteModal deletePimUser(String firstname, String lastname) {
    searchResult.shouldHave(text(firstname));
    searchResult.shouldHave(text(lastname));
    searchResult.find(deleteButton).click();
    return new DeleteModal();
  }

  public void confirmDeletePimUser() {
    deleteConfirmation.should(appear, ofSeconds(5)).shouldHave(text("Successfully Deleted"));
  }
}
