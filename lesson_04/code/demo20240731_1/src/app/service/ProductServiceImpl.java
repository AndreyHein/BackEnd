package app.service;

import app.entity.Product;
import app.exception.ProductNotFoundException;
import app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = repository.findAll();
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return findAll()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findAny().orElseThrow(() -> new ProductNotFoundException());
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
