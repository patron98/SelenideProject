package com.patron.pages.recruitment.vacancy;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.modals.DeleteModal;
import java.util.function.Function;
import org.openqa.selenium.By;

public class VacancyPage {

  private final SelenideElement addVacancyButton = $(byText("Add"));
  private final SelenideElement searchButton = $(byText("Search"));
  private final SelenideElement searchResult = $("div.oxd-table-row", 1);
  private final SelenideElement deleteConfirmation = $("p.oxd-text--toast-message");

  private final Function<String, SelenideElement> expandOption = option
      -> $x(format("//label[text()='%s']/following::i", option));
  private final Function<String, SelenideElement> selectOption = option
      -> $x(format("//div[@class='oxd-select-option' and contains(., '%s')]", option));

  private final By deleteButton = byCssSelector("i.oxd-icon.bi-trash");

  public AddVacancyPage goToAddVacancy() {
    addVacancyButton.shouldBe(visible, ofSeconds(10)).click();
    return new AddVacancyPage();
  }

  public VacancyPage searchVacancy(String type) {
    expandOption.apply("Vacancy").click();
    selectOption.apply(type).click();
    searchButton.click();
    return this;
  }

  public DeleteModal deleteVacancy(String type) {
    searchResult.shouldHave(text(type));
    searchResult.find(deleteButton).click();
    return new DeleteModal();
  }

  public void confirmDeleteVacancy() {
    deleteConfirmation.should(appear, ofSeconds(5)).shouldHave(text("Successfully Deleted"));
  }
}
