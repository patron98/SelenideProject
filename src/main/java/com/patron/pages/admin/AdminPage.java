package com.patron.pages.admin;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AdminPage {
    private final SelenideElement addButton = $x("//button[contains(.,'Add')]");
    public CreateAdminUserPage goTocreateNewUser() {
        addButton.click();
        return new CreateAdminUserPage();
    }
}
