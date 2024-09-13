package de.ait.shop42.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product not found")
@Getter
public class ProductNotFoundException extends RuntimeException {
    private ApiError apiError;
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(ApiError apiError) {
        this.apiError = apiError;
    }
}
