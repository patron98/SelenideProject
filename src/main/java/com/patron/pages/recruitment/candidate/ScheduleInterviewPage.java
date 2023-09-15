package com.patron.pages.recruitment.candidate;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.Page;
import java.util.function.Function;

public class ScheduleInterviewPage extends Page {

  private final Function<String, SelenideElement> input = input ->
      $x(format("//label[text()='%s']/following::input[1]", input));
  private final SelenideElement autocomplete = $(byText("Marko Polo"));
  private final SelenideElement save = $(byText("Save"));

  public CandidateDetailPage scheduleInterview(String date) {
    input.apply("Interview Title").shouldBe(visible, wait).sendKeys("title");
    input.apply("Interviewer").sendKeys("Marko");
    autocomplete.click();
    input.apply("Date").sendKeys(date);
    save.click();
    return new CandidateDetailPage();
  }
}
