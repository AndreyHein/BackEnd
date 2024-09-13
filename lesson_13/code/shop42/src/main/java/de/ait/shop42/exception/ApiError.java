package de.ait.shop42.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter

public class ApiError {
    private String message;
    private HttpStatus status;
}
