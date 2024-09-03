package de.ait.shop42.product.controller;

import de.ait.shop42.product.dto.ProductRequestDTO;
import de.ait.shop42.product.dto.ProductResponseDTO;
import de.ait.shop42.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/products")
    public List<ProductResponseDTO> getProducts(@RequestParam(name = "active", required = false) Boolean active) {
        return service.getProducts(active);
    };

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable (name = "id") Long id) {
        return service.getById(id);
    }

    @PostMapping("/products")
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO dto) {

        return service.createNewProduct(dto);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDTO updateProduct(@PathVariable(name = "id") Long id, @RequestBody ProductRequestDTO dto) {
        return service.updateProduct(id, dto);
    }

    @PatchMapping("/products/{id}")
    public ProductResponseDTO setProductActiveStatus(@RequestParam(name = "active", defaultValue = "true") boolean active, @PathVariable(name = "id") Long id) {
        return service.setActiveStatus(id, active);
    }
}
