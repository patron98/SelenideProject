package com.patron.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PIMPage {

    private final SelenideElement addEmployeeLink = $(byText("Add Employee"));


    public AddPIMUserPage goToAddPage() {
        addEmployeeLink.click();
        return new AddPIMUserPage();
    }
}
