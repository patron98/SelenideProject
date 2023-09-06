package com.patron.service;

import com.patron.pages.SearchBar;

public class AdminService {

    public void createNewUser(String firtname, String lastname) {
        new SearchBar()
                .openAdminPage()
                .goTocreateNewUser()
                .createUser(firtname, lastname);
    }
}
