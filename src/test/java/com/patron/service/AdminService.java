package com.patron.service;

import com.patron.pages.SearchBar;
import com.patron.pages.admin.AdminPage;

public class AdminService {

  public void createNewUser(String username) {
    new SearchBar()
        .openAdminPage()
        .goToAddUser()
        .createUser(username);
  }

  public void confirmCreatedUser() {
    new AdminPage().checkCreatedUser();
  }

  public void deleteAdminUser(String username) {
    new SearchBar()
        .openAdminPage()
        .deleteUser(username)
        .confirmDelete();
  }

  public void confirmDeletedUser() {
    new AdminPage().checkDeletedUser();
  }
}
