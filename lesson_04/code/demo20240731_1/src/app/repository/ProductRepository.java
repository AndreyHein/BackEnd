package app.repository;

import app.entity.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> findAll();
    public Product save(Product product);
}
