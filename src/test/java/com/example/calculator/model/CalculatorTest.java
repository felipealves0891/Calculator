package com.example.calculator.model;

import com.example.calculator.exception.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorTest {

    @Test
    public void plus_calculate_sum() {
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        calculator.setNumerator(3);
        calculator.setDenominator(7);

        //Assert
        assertEquals(10, calculator.plus());
    }

    @Test
    public void minus_calculate_subtraction() {
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        calculator.setNumerator(10);
        calculator.setDenominator(3);

        //Assert
        assertEquals(7, calculator.minus());
    }

    @Test
    public void division_calculate_half() throws InvalidOperationException {
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        calculator.setNumerator(10);
        calculator.setDenominator(2);

        //Assert
        assertEquals(5, calculator.division());
    }

    @Test
    public void division_calculate_byZero() {
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        calculator.setNumerator(10);
        calculator.setDenominator(0);

        //Assert
        InvalidOperationException exception
                = assertThrows(
                        InvalidOperationException.class,
                        () -> calculator.division(),
                "Caso o denomerador seja 0(zero), deve lançar uma exceção");

        assertEquals("Não a divisão por zero!", exception.getMessage());
    }

    @Test
    public void times_calculate_multiply() {
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        calculator.setNumerator(2);
        calculator.setDenominator(5);

        //Assert
        assertEquals(10, calculator.times());
    }
}

