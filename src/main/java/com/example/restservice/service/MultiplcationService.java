package com.example.restservice.service;

import com.example.restservice.domain.Multiplication;
import com.example.restservice.domain.MultiplicationResultAttempt;

public interface MultiplcationService {
    Multiplication createRandomMultiplcation(Multiplication multiplication);
    Multiplication setMultiplication();
    boolean checkAttempt(final MultiplicationResultAttempt multiplicationResultAttempt);
}
