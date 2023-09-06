package com.patron.service;

import com.patron.pages.SearchBar;
import com.patron.pages.admin.AdminPage;
import com.patron.pages.admin.CreateAdminUserPage;

public class AdminService {

  public void createNewUser(String username) {
    new SearchBar()
        .openAdminPage()
        .goToCreateNewUser()
        .createUser(username);
  }

  public void confirmCreatedUser() {
    new CreateAdminUserPage().checkCreatedUser();
  }

  public void deleteAdminUser(String username) {
    new SearchBar()
        .openAdminPage()
        .deleteUser(username)
        .confirmDeleteUser();
  }

  public void confirmDeletedUser() {
    new AdminPage().checkDeletedUser();
  }
}
