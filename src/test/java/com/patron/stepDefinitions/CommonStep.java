package com.patron.stepDefinitions;

import com.patron.service.Service;
import io.cucumber.java.en.Given;

public class CommonStep {

    private final Service service = new Service();
    @Given("I open the website")
    public void iOpenTheWebsite() {
        service.openPage();
    }
}
