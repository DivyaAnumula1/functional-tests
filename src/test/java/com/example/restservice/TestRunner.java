package com.example.restservice;

import com.example.restservice.config.IntegrationTestConfig;
import com.example.restservice.config.UnitTestConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue = {"com.example.restservice.stepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber", "junit:target/cucumber/cucumber-results.xml"}
)
public class TestRunner {
}
