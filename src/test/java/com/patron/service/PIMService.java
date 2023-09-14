package com.patron.service;

import com.patron.pages.SearchBar;
import com.patron.pages.pim.PIMPage;

public class PIMService {

  public void addPIMUser(String firstname, String lastname) {
    new SearchBar()
        .openPimPage()
        .goToAddPimUser()
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
        .searchPimUser(firstname, lastname)
        .deletePimUser(firstname, lastname)
        .confirmDelete();
  }

  public void checkDeletedPIMUser() {
    new PIMPage().confirmDeletePimUser();
  }
}
