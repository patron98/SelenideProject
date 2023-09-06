package com.patron.pages.directory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.util.function.Function;
import org.openqa.selenium.By;

public class DirectoryPage {

  private final SelenideElement searchEmployeeInput = $(
      byCssSelector("input[placeholder='Type for hints...']"));
  private final SelenideElement searchButton = $(byCssSelector("button[type='submit']"));
  private final SelenideElement employeeSheet = $(byClassName("oxd-sheet"));
  private final Function<String, SelenideElement> autocomplete = name ->
      Selenide.$(byText(name));
  private final By employeeName = byClassName("oxd-text");

  public DirectoryPage searchPIMUser(String firstname, String lastname) {
    searchEmployeeInput.sendKeys(firstname);
    autocomplete.apply(firstname + " " + lastname).shouldBe(visible).click();
    searchButton.click();
    return this;
  }

  public void checkNewPIMUser(String firstname, String lastname) {
    employeeSheet.find(employeeName).shouldHave(text(firstname));
    employeeSheet.find(employeeName).shouldHave(text(lastname));
  }
}
