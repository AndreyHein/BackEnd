package app.service;

import app.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(Long id);
    public  Product save(Product product);
}
