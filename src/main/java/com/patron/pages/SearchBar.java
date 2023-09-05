package com.patron.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchBar {
    private final SelenideElement searchField = $(byAttribute("placeholder", "Search"));
    private final SelenideElement PIM = $(byText("PIM"));
    private final SelenideElement directory = $(byText("Directory"));
    private void search(String searchInput) {
        searchField.sendKeys(searchInput);
    }

    public PIMPage openPimPage() {
        search("PIM");
        PIM.click();
        return new PIMPage();
    }

    public DirectoryPage openDirectoryPage(){
        search("Directory");
        directory.click();
        return new DirectoryPage();
    }
}
