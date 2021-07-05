package com.example.restservice.config;

import com.example.restservice.domain.Multiplication;
import com.example.restservice.service.MultiplcationService;
import com.example.restservice.service.MultiplicationServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Arrays;
@Component
@Import({IntegrationTestConfig.class,UnitTestConfig.class})
public class TestConfig implements EnvironmentAware{

    @Autowired
    private Environment environment;
    //private String priority;
    @Value("${spring.profiles.active}")
    private String activeProfile;

    MultiplcationService multiplcationService;

    @Bean
    public Multiplication loadConfigsBasedOnProfile(Multiplication request) {
        multiplcationService = new MultiplicationServiceImpl();
        if(activeProfile.equals("unit-test")) {
            return multiplcationService.createRandomMultiplcation(request);
        } else if(activeProfile.equals("integration-test")) {
            IntegrationTestConfig integrationTestConfig = new IntegrationTestConfig();
            String activeProfile = integrationTestConfig.getActiveProfile();
            String[] p = environment.getActiveProfiles();

            return integrationTestConfig.getBookClient().get();
        }
        return new Multiplication(2,3);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public String load(String propertyName)
    {
        return environment.getRequiredProperty(propertyName);
    }
}
