package com.patron.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.patron.pages.admin.AdminPage;
import com.patron.pages.directory.DirectoryPage;
import com.patron.pages.pim.PIMPage;

import java.util.function.Function;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchBar {
    private final SelenideElement searchField = $(byAttribute("placeholder", "Search"));
    private final Function<String, SelenideElement> searchResult = search -> $(byText(search));
    private void search(String searchInput) {
        searchField.sendKeys(searchInput);
    }

    public PIMPage openPimPage() {
        search("PIM");
        searchResult.apply("PIM").click();
        return new PIMPage();
    }

    public DirectoryPage openDirectoryPage(){
        search("Directory");
        searchResult.apply("Directory").click();
        return new DirectoryPage();
    }

    public AdminPage openAdminPage(){
        search("Admin");
        searchResult.apply("Admin");
        return new AdminPage();
    }
}
