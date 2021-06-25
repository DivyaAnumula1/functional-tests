package com.example.restservice.stepDefinitions;

import com.example.restservice.domain.Multiplication;
import com.example.restservice.service.MultiplcationService;
import com.example.restservice.service.MultiplicationServiceImpl;
import com.example.restservice.service.RandomGeneratorService;
import com.example.restservice.service.RandomGeneratorServiceImpl;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.mockito.Mockito.when;

@Configuration
public class Steps {

    @Autowired
    RandomGeneratorService randomGeneratorService;

    @Autowired
    MultiplcationService multiplcationService;

    @BeforeStep
    public void before() {
        randomGeneratorService = new RandomGeneratorServiceImpl();
        multiplcationService = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Given("calculations API is available")
    public void greetingAPI() {

    }

    @When("invoke the API with a user")
    public void invoke() {
        //randomGeneratorService.generateRandomFactor();
        Multiplication multiplication = multiplcationService.createRandomMultiplcation();
    }
    @Then("response should be valid")
    public void responseValidation() {

    }
}
