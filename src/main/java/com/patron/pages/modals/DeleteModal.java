package com.patron.pages.modals;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.pim.PIMPage;

public class DeleteModal {

  private final SelenideElement confirmDelete = $(byXpath("//button[contains(.,'Yes, Delete')]"));

  public PIMPage confirmDeleteUser() {
    confirmDelete.click();
    return new PIMPage();
  }
}
