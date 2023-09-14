package com.patron.pages.recruitment.vacancy;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.SelenideElement;
import java.util.function.Function;

public class AddVacancyPage {

  private final Function<String, SelenideElement> inputs = inputName
      -> $x(format("//label[text()='%s']/following::input[1]", inputName));
  private final SelenideElement jobTitleExpansion = $x("//label[text()='Job Title']/following::i");
  private final SelenideElement selectOption = $x(
      "//div[@class='oxd-select-option' and contains(., 'Account Assistant')]");
  private final SelenideElement autoCompleteSelect = $(byText("Marko Polo"));
  private final SelenideElement saveButton = $(byText("Save"));

  public AddVacancyPage createVacancy(String type, String manager) {
    inputs.apply("Vacancy Name").sendKeys(type);

    inputs.apply("Hiring Manager").sendKeys(manager);
    autoCompleteSelect.click();

    jobTitleExpansion.click();
    selectOption.should(appear, ofSeconds(5)).click();
    saveButton.click();
    return this;
  }
}
