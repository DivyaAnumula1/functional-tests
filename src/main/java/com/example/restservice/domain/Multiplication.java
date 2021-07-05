package com.example.restservice.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Multiplication {
    private int factorA;
    private int factorB;

    public Multiplication(int factorA, int factorB) {
        factorA = this.factorA;
        factorB = this.factorB;
    }
}
