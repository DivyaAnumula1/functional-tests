package com.example.restservice.controller;

import com.example.restservice.domain.Multiplication;
import com.example.restservice.service.MultiplcationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {
    private final MultiplcationService multiplcationService;

    @Autowired
    public MultiplicationController(MultiplcationService multiplcationService) {
        this.multiplcationService = multiplcationService;
    }

    @GetMapping("/random")
    Multiplication getMultiplication() {
        return multiplcationService.createRandomMultiplcation();
    }
}
