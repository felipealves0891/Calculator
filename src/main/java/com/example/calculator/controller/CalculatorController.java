package com.example.calculator.controller;

import com.example.calculator.exception.InvalidOperationException;
import com.example.calculator.model.Calculator;
import com.example.calculator.model.dto.PayloadDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class CalculatorController {

    @GetMapping(path = "/sum/{numerator}/{denominator}")
    public ResponseEntity<PayloadDto> sum(
            @PathVariable("numerator") final Integer numerator,
            @PathVariable("denominator") final Integer denominator) {
        int result = factoryCalculator(numerator, denominator).plus();
        return ResponseEntity.ok().body(factoryPayloadOk(result));
    }

    @GetMapping(path = "/subtract/{numerator}/{denominator}")
    public ResponseEntity subtract(
            @PathVariable("numerator") final Integer numerator,
            @PathVariable("denominator") final Integer denominator) {
        int result = factoryCalculator(numerator, denominator).minus();
        return  ResponseEntity.ok().body(factoryPayloadOk(result));
    }

    @GetMapping(path = "/division/{numerator}/{denominator}")
    public ResponseEntity division(
            @PathVariable("numerator") final Integer numerator,
            @PathVariable("denominator") final Integer denominator) {

        double result;
        try {
            result = factoryCalculator(numerator, denominator).division();
            return  ResponseEntity.ok().body(factoryPayloadOk(result));
        } catch (InvalidOperationException e) {
            return  ResponseEntity.badRequest().body(factoryPayloadBadRequest(e.getMessage()));
        }
    }

    @GetMapping(path = "/multiply/{numerator}/{denominator}")
    public ResponseEntity multiply(
            @PathVariable("numerator") final Integer numerator,
            @PathVariable("denominator") final Integer denominator) {
        double result = factoryCalculator(numerator, denominator).times();
        return ResponseEntity.ok().body(factoryPayloadOk(result));
    }

    private Calculator factoryCalculator(Integer numerator, Integer denominator) {
        Calculator calculator = new Calculator();
        calculator.setNumerator(numerator);
        calculator.setDenominator(denominator);
        return calculator;
    }

    private PayloadDto factoryPayloadOk(Object data) {
        return new PayloadDto(HttpStatus.OK, data);
    }

    private PayloadDto factoryPayloadBadRequest(Object data) {
        return new PayloadDto(HttpStatus.BAD_REQUEST, data);
    }
}
