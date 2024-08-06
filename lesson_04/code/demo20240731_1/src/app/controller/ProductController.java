package app.controller;

import app.entity.Product;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    public List<Product> getAllProducts() {
        List<Product> products = service.findAll();
        return service.findAll();
    }

    public Product getProductById(Long id) {
        return service.findById(id);
    }
}
