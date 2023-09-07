package com.patron.pages.recruitment.candidate;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class ConfirmPage {

  private final SelenideElement saveButton = $("button[type='submit']");
  private final SelenideElement confirmCreated = $(
      "p.oxd-text.oxd-text--p.oxd-text--toast-message");


  public CandidateDetailPage accept() {
    saveButton.click();
    confirmCreated.should(appear).shouldHave(text("Successfully Updated"));
    return new CandidateDetailPage();
  }


}
