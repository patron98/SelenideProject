package com.patron.service;

import com.patron.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class CommonService {
    private final static String url = "https://opensource-demo.orangehrmlive.com/";

    public void openPage() {
        open(url);
    }

    public void userLogin() {
        new LoginPage().login();
    }
}
