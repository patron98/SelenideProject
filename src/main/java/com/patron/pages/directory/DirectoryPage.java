package com.patron.pages.directory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.Page;
import java.util.function.Function;
import org.openqa.selenium.By;

public class DirectoryPage extends Page {

  private final SelenideElement searchEmployeeInput = $(
      byCssSelector("input[placeholder='Type for hints...']"));
  private final SelenideElement searchButton = $(byCssSelector("button[type='submit']"));
  private final SelenideElement employeeSheet = $(byClassName("oxd-sheet"));
  private final Function<String, SelenideElement> autocomplete = name ->
      $(byText(name));
  private final By employeeName = byClassName("oxd-text");

  public DirectoryPage searchPIMUser(String firstname, String lastname) {
    searchEmployeeInput.shouldBe(visible, wait).sendKeys(firstname);
    autocomplete.apply(firstname + " " + lastname).shouldBe(visible).click();
    executeJavaScript("arguments[0].click();", searchButton);
    return this;
  }

  public void checkNewPIMUser(String firstname, String lastname) {
    employeeSheet.find(employeeName).shouldHave(text(firstname), wait);
    employeeSheet.find(employeeName).shouldHave(text(lastname), wait);
  }
}
