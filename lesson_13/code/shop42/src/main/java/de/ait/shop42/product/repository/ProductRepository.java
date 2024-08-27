package de.ait.shop42.product.repository;

import de.ait.shop42.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByActive(boolean active);

}
