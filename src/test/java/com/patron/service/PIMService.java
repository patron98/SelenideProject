package com.patron.service;

import com.patron.pages.LoginPage;
import com.patron.pages.pim.PIMPage;
import com.patron.pages.SearchBar;

import static com.codeborne.selenide.Selenide.open;

public class PIMService {

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
