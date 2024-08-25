package de.ait.shop42.product.service;

import de.ait.shop42.product.dto.ProductRequestDTO;
import de.ait.shop42.product.dto.ProductResponseDTO;
import de.ait.shop42.product.entity.Product;
import de.ait.shop42.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
}
