package com.patron.pages.recruitment.candidate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.Page;
import java.util.function.Function;

public class CandidateDetailPage extends Page {

  private final Function<String, SelenideElement> buttonValue = value -> $(
      byText(value));
  private final SelenideElement hireStatus = $(byClassName("orangehrm-recruitment-status"));

  public ConfirmPage goToAcceptCandidate() {
    buttonValue.apply("Shortlist").shouldBe(visible, wait).click();
    return new ConfirmPage();
  }

  public ScheduleInterviewPage goToScheduleInterview() {
    buttonValue.apply("Schedule Interview").shouldBe(visible, wait).click();
    return new ScheduleInterviewPage();
  }

  public ConfirmPage markInterviewPassed() {
    buttonValue.apply("Mark Interview Passed").shouldBe(visible, wait).click();
    return new ConfirmPage();
  }

  public ConfirmPage offerJob() {
    buttonValue.apply("Offer Job").shouldBe(visible, wait).click();
    return new ConfirmPage();
  }

  public ConfirmPage hire() {
    buttonValue.apply("Hire").shouldBe(visible, wait).click();
    return new ConfirmPage();
  }

  public void checkStatus() {
    hireStatus.shouldHave(text("Hired"));
  }
}
