package com.example.restservice.service;

import com.example.restservice.domain.Multiplication;
import com.example.restservice.domain.MultiplicationResultAttempt;

public interface MultiplcationService {
    Multiplication createRandomMultiplcation();
    boolean checkAttempt(final MultiplicationResultAttempt multiplicationResultAttempt);
}
