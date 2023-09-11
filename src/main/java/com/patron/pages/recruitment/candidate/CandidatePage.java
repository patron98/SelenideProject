package com.patron.pages.recruitment.candidate;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.modals.DeleteModal;
import java.util.function.Function;
import org.openqa.selenium.By;

public class CandidatePage {

  private final SelenideElement addCandidateButton = $(byText("Add"));
  private final SelenideElement searchCandidate = $x(
      "//label[text()='Candidate Name']/following::input[1]");
  private final SelenideElement searchButton = $(byText("Search"));
  private final SelenideElement searchResult = $("div.oxd-table-row", 1);
  private final SelenideElement deleteConfirmation = $("p.oxd-text--toast-message");
  private final Function<String, SelenideElement> autocomplete = name -> $(byText(name));
  private final By deleteButton = byCssSelector("i.oxd-icon.bi-trash");

  public AddCandidatePage goToAddCandidatePage() {
    addCandidateButton.shouldBe(visible, ofSeconds(5)).click();
    return new AddCandidatePage();
  }

  public CandidatePage searchCandidate(String firstname, String lastname) {
    searchCandidate.shouldBe(visible, ofSeconds(5)).sendKeys(firstname);
    autocomplete.apply(firstname + " " + lastname).shouldBe(visible).click();
    executeJavaScript("arguments[0].click();", searchButton);
    return this;
  }

  public DeleteModal deleteCandidate(String firstname, String lastname) {
    searchResult.shouldHave(text(firstname));
    searchResult.shouldHave(text(lastname));
    searchResult.find(deleteButton).click();
    return new DeleteModal();
  }

  public void confirmDeleteCandidate() {
    deleteConfirmation.should(appear, ofSeconds(5)).shouldHave(text("Successfully Deleted"));
  }
}
