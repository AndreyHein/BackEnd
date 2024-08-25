package de.ait.shop42.product.controller;

import de.ait.shop42.product.dto.ProductRequestDTO;
import de.ait.shop42.product.dto.ProductResponseDTO;
import de.ait.shop42.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/products")
    public List<ProductResponseDTO> getProducts() {
        return service.getAllProducts();
    };

    @PostMapping("/products")
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO dto) {

        return service.createNewProduct(dto);
    }
}
