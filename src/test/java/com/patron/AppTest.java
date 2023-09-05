package com.patron;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "com/patron/features",
        glue = "com.patron.stepDefinitions",
        plugin = "json:target/reports.json")
public class AppTest {

}
