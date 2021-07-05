package com.example.restservice.client;

import com.example.restservice.domain.Multiplication;
import feign.RequestLine;

public interface MultiplicationClient {
    @RequestLine("GET")
    Multiplication get();
}
