package com.example.restservice.controller;

import com.example.restservice.domain.MultiplicationResultAttempt;
import com.example.restservice.service.MultiplcationService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MultiplicationResultAttemptController {
    private final MultiplcationService multiplcationService;

    @Autowired
    public MultiplicationResultAttemptController(MultiplcationService multiplcationService) {
        this.multiplcationService = multiplcationService;
    }

    @PostMapping
    ResponseEntity<ResultResponse> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        return ResponseEntity.ok(new ResultResponse(multiplcationService.checkAttempt(multiplicationResultAttempt)));
    }

    @RequiredArgsConstructor
    @Getter
    @NoArgsConstructor(force = true)
    private static final class ResultResponse {
        private final boolean correct;
    }
}
