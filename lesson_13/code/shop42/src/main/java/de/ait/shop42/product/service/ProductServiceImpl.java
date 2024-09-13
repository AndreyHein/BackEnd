package de.ait.shop42.product.service;

import de.ait.shop42.exception.ApiError;
import de.ait.shop42.exception.ProductNotFoundException;
import de.ait.shop42.product.dto.ProductRequestDTO;
import de.ait.shop42.product.dto.ProductResponseDTO;
import de.ait.shop42.product.entity.Product;
import de.ait.shop42.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return repository.findAll().stream()
                .map(p -> mapper.map(p, ProductResponseDTO.class))
                .toList();
    }

    @Override
    public ProductResponseDTO createNewProduct(ProductRequestDTO dto) {

        Product entity = mapper.map(dto, Product.class);        // dto --> Product
        entity = repository.save(entity);

        return mapper.map(entity, ProductResponseDTO.class);    // entity --> dto
    }

    @Override
    @Transactional
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {
        Product entity = mapper.map(dto, Product.class);
        entity.setId(id);
        entity = repository.save(entity);
        return mapper.map(entity, ProductResponseDTO.class);
    }

    @Override
    @Transactional
    public ProductResponseDTO setActiveStatus(Long id, boolean active) {
        String exceptionMsg = String.format("Change active status fail. ", id);
        Product productEntity = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(exceptionMsg));
        productEntity.setActive(active);
        return mapper.map(productEntity, ProductResponseDTO.class);
    }

    @Override
    public List<ProductResponseDTO> getProducts(Boolean active) {
        if (active == null) {
            return getAllProducts();
        } else {
            List<Product> productByActive = repository.findByActive(active);
            return productByActive.stream()
                    .map(p -> mapper.map(p, ProductResponseDTO.class))
                    .toList();
        }
    }

    @Override
    public ProductResponseDTO getById(Long id) {
        return mapper.map(findProductById(id), ProductResponseDTO.class);
    }

    @Override
    public Product findProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(new ApiError(String.format("Product id %d not found", id), HttpStatus.NOT_FOUND)));
    }
}
