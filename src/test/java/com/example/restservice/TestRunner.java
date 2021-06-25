package com.example.restservice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue = {"com.example.restservice.stepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber", "junit:target/cucumber/cucumber-results.xml"}
)
public class TestRunner {
}
