package com.patron.pages.pim;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.Page;

public class AddPIMUserPage extends Page {

  private final SelenideElement firstnameInput = $(byName("firstName"));
  private final SelenideElement lastnameInput = $(byName("lastName"));
  private final SelenideElement save = $(byCssSelector("button[type='submit']"));

  public PIMUserDetailPage addPIMUser(String firstname, String lastname) {
    firstnameInput.shouldBe(visible, wait).sendKeys(firstname);
    lastnameInput.sendKeys(lastname);
    save.click();
    return new PIMUserDetailPage();
  }
}
