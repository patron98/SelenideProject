package com.patron.stepDefinitions;

import com.patron.service.CommonService;
import com.patron.service.PIMService;
import io.cucumber.java.en.Given;

public class CommonStep {

    private final CommonService  commonService = new CommonService();
    @Given("I open the website")
    public void iOpenTheWebsite() {
        commonService.openPage();
    }
}
