package de.ait.shop42.product.controller;

import de.ait.shop42.exception.ApiError;
import de.ait.shop42.exception.ProductNotFoundException;
import de.ait.shop42.product.dto.ProductRequestDTO;
import de.ait.shop42.product.dto.ProductResponseDTO;
import de.ait.shop42.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDTO>> getProducts(@RequestParam(name = "active", required = false) Boolean active) {
        return new ResponseEntity<>(service.getProducts(active), HttpStatus.OK);
    };

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable (name = "id") Long id) {
        return service.getById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO dto) {
        return new ResponseEntity<>(service.createNewProduct(dto), HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDTO updateProduct(@PathVariable(name = "id") Long id, @RequestBody ProductRequestDTO dto) {
        return service.updateProduct(id, dto);
    }

    @PatchMapping("/products/{id}")
    public ProductResponseDTO setProductActiveStatus(@RequestParam(name = "active", defaultValue = "true") boolean active, @PathVariable(name = "id") Long id) {
        return service.setActiveStatus(id, active);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiError> exceptionProductNotFoundHandler(ProductNotFoundException e) {
        return new ResponseEntity<>(e.getApiError(), e.getApiError().getStatus());
    }
}
