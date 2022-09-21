package com.example.calculator.model;

import com.example.calculator.exception.InvalidOperationException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Calculator {

    @Getter
    @Setter
    private int numerator;

    @Getter
    @Setter
    private int denominator;

    public int plus() {
        return numerator + denominator;
    }

    public int minus() {
        return  numerator - denominator;
    }

    public double division() throws InvalidOperationException {
        if(denominator == 0)
            throw new InvalidOperationException("Não a divisão por zero!");
        return numerator / denominator;
    }

    public double times() {
        return  numerator * denominator;
    }
}
