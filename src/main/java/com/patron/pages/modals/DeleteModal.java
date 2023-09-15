package com.patron.pages.modals;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.Page;

public class DeleteModal extends Page {

  private final SelenideElement confirmDelete = $(byXpath("//button[contains(.,'Yes, Delete')]"));

  public void confirmDelete() {
    confirmDelete.should(appear, wait).click();
  }
}
