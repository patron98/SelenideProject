package com.patron.pages.admin;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import java.util.function.Function;

public class AddAdminUserPage {

  private final Function<String, SelenideElement> expandOption = option
      -> $x(format("//label[text()='%s']/following::i", option));
  private final Function<String, SelenideElement> selectOption = option
      -> $x(format("//div[@class='oxd-select-option' and contains(., '%s')]", option));
  private final Function<String, SelenideElement> inputs = inputName
      -> $x(format("//label[text()='%s']/following::input[1]", inputName));
  private final SelenideElement autocompleteAdminUser = $(byText("Marko Polo"));
  private final SelenideElement save = $("button[type='submit']");
  private final SelenideElement confirmCreated = $("p.oxd-text--toast-message");

  public AdminPage createUser(String username) {
    expandOption.apply("User Role").click();
    selectOption.apply("Admin").click();

    expandOption.apply("Status").click();
    selectOption.apply("Enabled").click();

    inputs.apply("Employee Name").sendKeys("Marko");
    autocompleteAdminUser.click();

    inputs.apply("Username").sendKeys(username);
    inputs.apply("Password").sendKeys("password123");
    inputs.apply("Confirm Password").sendKeys("password123");

    save.click();
    return new AdminPage();
  }


}
