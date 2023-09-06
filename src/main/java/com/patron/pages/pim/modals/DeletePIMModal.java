package com.patron.pages.pim.modals;

import com.codeborne.selenide.SelenideElement;
import com.patron.pages.pim.PIMPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DeletePIMModal {

    private final SelenideElement confirmDelete = $(byXpath("//button[contains(.,'Yes, Delete')]"));

    public PIMPage confirmDeleteUser(){
        confirmDelete.click();
        return new PIMPage();
    }
}
