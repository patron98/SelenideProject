package com.patron.service;

import com.patron.pages.HomePage;
import com.patron.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class Service {
    private final String url = "https://opensource-demo.orangehrmlive.com/";

    public void openPage() {
        open(url);
    }

    public void userLogin() {
        new LoginPage().login();
    }

    public void search(String searchInput) {
        new HomePage().search(searchInput);
    }
}
