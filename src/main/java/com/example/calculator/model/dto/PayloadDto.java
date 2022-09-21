package com.example.calculator.model.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
public class PayloadDto {

    private final HttpStatus status;

    private final Object data;

    private final ZonedDateTime timestamp;

    public PayloadDto(HttpStatus status, Object data) {
        this.status = status;
        this.data = data;
        this.timestamp = ZonedDateTime.now(ZoneId.of("Z"));
    }
}
