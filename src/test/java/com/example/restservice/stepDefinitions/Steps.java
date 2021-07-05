package com.example.restservice.stepDefinitions;

import com.example.restservice.client.MultiplicationClient;
import com.example.restservice.config.TestConfig;
import com.example.restservice.domain.Multiplication;
import com.example.restservice.service.MultiplcationService;
import com.example.restservice.service.MultiplicationServiceImpl;
import com.example.restservice.service.RandomGeneratorService;
import com.example.restservice.service.RandomGeneratorServiceImpl;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Steps {

    @Autowired
    RandomGeneratorService randomGeneratorService;

    @Autowired
    MultiplcationService multiplcationService;

    private MultiplicationClient multiplicationClient;
    private TestConfig testConfig;

    @BeforeStep
    public void before() {
        randomGeneratorService = new RandomGeneratorServiceImpl();
        multiplcationService = new MultiplicationServiceImpl(randomGeneratorService);
        testConfig = new TestConfig();
    }

    @Given("calculations API is available")
    public void greetingApi() {

    }

    @When("invoke the API with a user")
    public void invoke() {
        Multiplication multiplication =
                new Multiplication(randomGeneratorService.generateRandomFactor()
                        ,randomGeneratorService.generateRandomFactor());
        //System.out.println("Steps env" + env.getActiveProfiles());
        testConfig.loadConfigsBasedOnProfile(multiplication);
    }
    @Then("response should be valid")
    public void responseValidation() {

    }
}
