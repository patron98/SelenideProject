package com.patron.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final SelenideElement searchField = $(byAttribute("placeholder", "Search"));
    public HomePage search(String searchInput) {
        searchField.sendKeys(searchInput);
        return this;
    }
}
