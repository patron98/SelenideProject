package com.patron.pages.recruitment.candidate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.Page;
import java.util.function.Function;

public class AddCandidatePage extends Page {

  private final SelenideElement firstnameInput = $(byName("firstName"));
  private final SelenideElement lastnameInput = $(byName("lastName"));
  private final SelenideElement emailInput = $x("//label[text()='Email']/following::input[1]");
  private final SelenideElement vacancyTypeSelect = $x(
      "//label[text()='Vacancy']/following::i");
  private final Function<String, SelenideElement> vacancyOption = vacancy ->
      $x(format("//div[@class='oxd-select-option' and contains(., '%s')]", vacancy));
  private final SelenideElement saveButton = $("button[type='submit']");
  private final SelenideElement confirmCreated = $("p.oxd-text--toast-message");

  public CandidateDetailPage createCandidate(String firstname, String lastname, String email,
      String type) {
    firstnameInput.shouldBe(visible, wait).sendKeys(firstname);
    lastnameInput.sendKeys(lastname);
    emailInput.sendKeys(email);
    vacancyTypeSelect.click();
    vacancyOption.apply(type).click();
    saveButton.click();
    return new CandidateDetailPage();
  }

  public void confirmCreatedCandidate() {
    confirmCreated.shouldHave(text("Successfully Saved"));
  }
}
