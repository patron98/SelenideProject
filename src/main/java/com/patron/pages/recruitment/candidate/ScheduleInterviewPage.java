package com.patron.pages.recruitment.candidate;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class ScheduleInterviewPage {

  private final SelenideElement dateInput = $x("//label[text()='Date']/following::input[1]");
  private final SelenideElement interviewTitle = $x(
      "//label[text()='Interview Title']/following::input[1]");
  private final SelenideElement interviewerName = $x(
      "//label[text()='Interviewer']/following::input[1]");
  private final SelenideElement autocomplete = $(byText("Marko Polo"));
  private final SelenideElement save = $(byText("Save"));

  public CandidateDetailPage scheduleInterview(String date) {
    interviewTitle.sendKeys("title");
    interviewerName.sendKeys("Marko");
    autocomplete.click();
    dateInput.sendKeys(date);
    save.click();
    return new CandidateDetailPage();
  }
}
