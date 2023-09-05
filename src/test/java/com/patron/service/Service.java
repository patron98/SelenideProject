package com.patron.service;

import com.patron.pages.HomePage;
import com.patron.pages.LoginPage;
import com.patron.pages.PIMPage;
import com.patron.pages.SearchBar;

import static com.codeborne.selenide.Selenide.open;

public class Service {
    private final String url = "https://opensource-demo.orangehrmlive.com/";

    public void openPage() {
        open(url);
    }

    public void userLogin() {
        new LoginPage().login();
    }

    public void goToPimPage() {
        new SearchBar().openPimPage();
    }

    public void addPIMUser(String firstname, String lastname) {
        new PIMPage()
                .goToAddPage()
                .addPIMUser(firstname, lastname);
    }

    public void checkCreatedPIMUserInDirectory(String firstname, String lastname) {
        new SearchBar()
                .openDirectoryPage()
                .searchPIMUser(firstname, lastname)
                .checkNewPIMUser(firstname, lastname);
    }
}
