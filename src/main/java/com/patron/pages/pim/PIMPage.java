package com.patron.pages.pim;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.patron.pages.pim.modals.DeletePIMModal;

import java.util.function.Function;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PIMPage {

    private final SelenideElement addEmployeeLink = $(byText("Add Employee"));
    private final SelenideElement employeeNameInput = $(byXpath("//label[text()='Employee Name']/following::input"));
    private final SelenideElement searchButton = $("button[type='submit']");
    private final SelenideElement searchResult = $("div.oxd-table-row", 1);
    private final SelenideElement deleteButton = $("i.oxd-icon.bi-trash");
    private final SelenideElement deleteConfirmation = $("p.oxd-text--toast-message");
    private final Function<String, SelenideElement> autocomplete = name ->
            Selenide.$(byText(name));

    public AddPIMUserPage goToAddPage() {
        addEmployeeLink.click();
        return new AddPIMUserPage();
    }

    public PIMPage searchPIMUser(String firstname, String lastname) {
        employeeNameInput.sendKeys(firstname);
        autocomplete.apply(firstname+ " " +lastname).click();
        searchButton.click();
        return this;
    }

    public DeletePIMModal deletePIMUser(String firstname, String lastname){
        searchResult.shouldHave(text(firstname));
        searchResult.shouldHave(text(lastname));
        deleteButton.click();
        return new DeletePIMModal();
    }

    public PIMPage confirmDeletePIMUser(){
        deleteConfirmation.shouldHave(text("Successfully Deleted"));
        return this;
    }
}
