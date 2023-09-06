package com.patron.pages;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.dashboard.Dashboard;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public final SelenideElement usernameInput = $(byName("username"));
    public final SelenideElement passwordInput = $(byName("password"));
    public final SelenideElement submit = $(byCssSelector("button"));

    public Dashboard login(){
        usernameInput.sendKeys("Admin");
        passwordInput.sendKeys("admin123");
        submit.click();
        return new Dashboard();
    }
}
