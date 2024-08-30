package de.ait.shop42.product.service;

import de.ait.shop42.product.dto.ProductRequestDTO;
import de.ait.shop42.product.dto.ProductResponseDTO;
import de.ait.shop42.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO createNewProduct(ProductRequestDTO dto);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto);

    ProductResponseDTO setActiveStatus(Long id, boolean active);

    List<ProductResponseDTO> getProducts(Boolean active);

    ProductResponseDTO getById(Long id);
    Product findProductById(Long id);
}

