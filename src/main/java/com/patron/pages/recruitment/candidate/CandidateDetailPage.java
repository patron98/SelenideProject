package com.patron.pages.recruitment.candidate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.SelenideElement;
import java.util.function.Function;

public class CandidateDetailPage {

  private final Function<String, SelenideElement> buttonValue = value -> $(
      byText(value));
  private final SelenideElement hireStatus = $(byClassName("orangehrm-recruitment-status"));

  public ConfirmPage goToAcceptCandidate() {
    buttonValue.apply("Shortlist").shouldBe(visible, ofSeconds(10)).click();
    return new ConfirmPage();
  }

  public ScheduleInterviewPage goToScheduleInterview() {
    buttonValue.apply("Schedule Interview").shouldBe(visible, ofSeconds(10)).click();
    return new ScheduleInterviewPage();
  }

  public ConfirmPage markInterviewPassed() {
    buttonValue.apply("Mark Interview Passed").shouldBe(visible, ofSeconds(10)).click();
    return new ConfirmPage();
  }

  public ConfirmPage offerJob() {
    buttonValue.apply("Offer Job").shouldBe(visible, ofSeconds(10)).click();
    return new ConfirmPage();
  }

  public ConfirmPage hire() {
    buttonValue.apply("Hire").shouldBe(visible, ofSeconds(10)).click();
    return new ConfirmPage();
  }

  public void checkStatus() {
    hireStatus.shouldHave(text("Hired"));
  }
}
