package com.patron.pages.recruitment.candidate;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.Page;
import com.patron.pages.modals.DeleteModal;
import com.patron.pages.recruitment.vacancy.VacancyPage;
import java.util.function.Function;
import org.openqa.selenium.By;

public class CandidatePage extends Page {

  private final SelenideElement addCandidateButton = $(byText("Add"));
  private final SelenideElement vacancy = $(byText("Vacancies"));
  private final SelenideElement candidates = $(byText("Candidates"));
  private final SelenideElement searchCandidate = $x(
      "//label[text()='Candidate Name']/following::input[1]");
  private final SelenideElement searchButton = $(byText("Search"));
  private final SelenideElement searchResult = $("div.oxd-table-row", 1);
  private final SelenideElement deleteConfirmation = $("p.oxd-text--toast-message");
  private final Function<String, SelenideElement> autocomplete = name -> $(byText(name));
  private final By deleteButton = byCssSelector("i.oxd-icon.bi-trash");

  public AddCandidatePage goToAddCandidate() {
    addCandidateButton.shouldBe(visible, wait).click();
    return new AddCandidatePage();
  }

  public CandidatePage goToCandidates() {
    candidates.shouldBe(visible, wait).click();
    return this;
  }

  public VacancyPage goToVacancyPage() {
    vacancy.shouldBe(visible, wait).click();
    return new VacancyPage();
  }

  public CandidatePage searchCandidate(String firstname, String lastname) {
    searchCandidate.shouldBe(visible, wait).type(lastname);
    autocomplete.apply(firstname + " " + lastname).should(appear, wait).click();
    executeJavaScript("arguments[0].click();", searchButton);
    return this;
  }

  public DeleteModal deleteCandidate(String firstname, String lastname) {
    searchResult.shouldHave(text(firstname), wait);
    searchResult.shouldHave(text(lastname), wait);
    searchResult.find(deleteButton).click();
    return new DeleteModal();
  }

  public void confirmDeleteCandidate() {
    deleteConfirmation.should(appear, wait).shouldHave(text("Successfully Deleted"));
  }
}
