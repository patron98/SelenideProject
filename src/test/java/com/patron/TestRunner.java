package com.patron;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
    glue = {"com.patron.stepDefinitions", "com.patron.hooks"},
    plugin = "json:target/reports.json")
public class TestRunner {

}
