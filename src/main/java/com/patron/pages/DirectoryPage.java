package com.patron.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.function.Function;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class DirectoryPage {

    private final SelenideElement searchEmployeeInput = $(byCssSelector("input[placeholder='Type for hints...']"));
    private final SelenideElement searchButton = $(byCssSelector("button[type='submit']"));
    private final SelenideElement employeeSheet = $(byClassName("oxd-sheet"));
    private final Function<String, SelenideElement> autocomplete = name ->
            Selenide.$(byXpath("//div[@role='listbox']//div[@role='option']//span[contains(text(),'" + name + "')]"));

    private final By employeeName = byClassName("oxd-text");

    public DirectoryPage searchPIMUser(String firstname, String lastname) {
        searchEmployeeInput.sendKeys(firstname);
        autocomplete.apply(firstname + " " + lastname).shouldBe(visible).click();
        searchButton.click();
        return this;
    }

    public void checkNewPIMUser(String firstname, String lastname) {
        employeeSheet.find(employeeName).shouldHave(text(firstname));
        employeeSheet.find(employeeName).shouldHave(text(lastname));
    }
}
