package com.example.calculator.controller;

import com.example.calculator.model.dto.PayloadDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CalculatorControllerTest {

    @Test
    public void sum_calculate_ok() {
        //Arrange
        CalculatorController controller = new CalculatorController();

        //Act
        ResponseEntity<PayloadDto> response = controller.sum(7, 3);

        //Assert
        Assertions.assertNotNull(response, "Response not be null.");
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody(), "Response body not be null.");
        Assertions.assertEquals(10, response.getBody().getData());
    }

    @Test
    public void subtract_calculate_ok() {
        //Arrange
        CalculatorController controller = new CalculatorController();

        //Act
        ResponseEntity<PayloadDto> response = controller.subtract(10, 3);

        //Assert
        Assertions.assertNotNull(response, "Response not be null.");
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody(), "Response body not be null.");
        Assertions.assertEquals(7, response.getBody().getData());
    }

    @Test
    public void division_calculate_ok() {
        //Arrange
        CalculatorController controller = new CalculatorController();

        //Act
        ResponseEntity<PayloadDto> response = controller.division(10, 5);

        //Assert
        Assertions.assertNotNull(response, "Response not be null.");
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody(), "Response body not be null.");
        Assertions.assertEquals(2.0, response.getBody().getData());
    }

    @Test
    public void division_calculation_badRequest() {
        //Arrange
        CalculatorController controller = new CalculatorController();

        //Act
        ResponseEntity<PayloadDto> response = controller.division(10, 0);

        //Assert
        Assertions.assertNotNull(response, "Response not be null.");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertNotNull(response.getBody(), "Response body not be null");
        Assertions.assertEquals("Não a divisão por zero!", response.getBody().getData());
    }

    @Test
    public void multiply_calculation_ok() {
        //Arrange
        CalculatorController controller = new CalculatorController();

        //Act
        ResponseEntity<PayloadDto> response = controller.multiply(5, 2);

        //Assert
        Assertions.assertNotNull(response, "Response not be null.");
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody(), "Response body not be null");
        Assertions.assertEquals(10.0, response.getBody().getData());
    }

}
