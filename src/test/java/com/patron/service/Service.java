package com.patron.service;

import com.patron.pages.LoginPage;
import com.patron.pages.PIMPage;
import com.patron.pages.SearchBar;

import static com.codeborne.selenide.Selenide.open;

public class Service {
    private final static String url = "https://opensource-demo.orangehrmlive.com/";

    public void openPage() {
        open(url);
    }

    public void userLogin() {
        new LoginPage().login();
    }

    public void addPIMUser(String firstname, String lastname) {
        new SearchBar()
                .openPimPage()
                .goToAddPage()
                .addPIMUser(firstname, lastname);
    }

    public void checkCreatedPIMUserInDirectory(String firstname, String lastname) {
        new SearchBar()
                .openDirectoryPage()
                .searchPIMUser(firstname, lastname)
                .checkNewPIMUser(firstname, lastname);
    }

    public void deletePIMUser(String firstname, String lastname) {
        new SearchBar()
                .openPimPage()
                .searchPIMUser(firstname, lastname)
                .deletePIMUser(firstname, lastname)
                .confirmDeleteUser();
    }

    public void checkDeletedPIMUser() {
        new PIMPage().confirmDeletePIMUser();
    }
}
