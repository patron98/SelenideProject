package com.patron.pages.pim;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class AddPIMUserPage {

  private final SelenideElement firstnameInput = $(byName("firstName"));
  private final SelenideElement lastnameInput = $(byName("lastName"));
  private final SelenideElement save = $(byCssSelector("button[type='submit']"));

  public PIMUserDetailPage addPIMUser(String firstname, String lastname) {
    firstnameInput.sendKeys(firstname);
    lastnameInput.sendKeys(lastname);
    save.click();
    return new PIMUserDetailPage();
  }
}
