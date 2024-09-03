package de.ait.shop42.customer.service;

import de.ait.shop42.cart.entity.Cart;
import de.ait.shop42.customer.entity.Customer;
import de.ait.shop42.customer.dto.CustomerRequestDto;
import de.ait.shop42.customer.dto.CustomerResponseDto;
import de.ait.shop42.customer.repository.CustomerRepository;
import de.ait.shop42.exception.CustomerNotFound;
import de.ait.shop42.product.entity.Product;
import de.ait.shop42.product.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final ModelMapper mapper;
    private final ProductService productService;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto dto) {
        Customer entity = mapper.map(dto, Customer.class);
        entity.setActive(true);
        Cart cart = new Cart();

        entity.setCart(cart);       // связь customer - cart
        cart.setCustomer(entity);
        entity = repository.save(entity);
        return mapper.map(entity, CustomerResponseDto.class);
    }

    @Override
    public List<CustomerResponseDto> getCustomers() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, CustomerResponseDto.class))
                .toList();
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        Customer customer = findCustomer(id);
        return mapper.map(customer, CustomerResponseDto.class);
    }

    private Customer findCustomer(Long id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFound("Customer ID: " + id + "not found"));
        return customer;
    }

    @Override
    @Transactional
    public CustomerResponseDto addProductToCart(Long customerId, Long productId) {
        Customer customer = findCustomer(customerId);
        Product product = productService.findProductById(productId);

        customer.getCart().addProduct(product);
        return mapper.map(customer, CustomerResponseDto.class);
    }

    @Override
    @Transactional
    public CustomerResponseDto removeProductFromCart(Long customerId, Long productId) {
        Customer customer = findCustomer(customerId);
        Product product = productService.findProductById(productId);

        customer.getCart().removeProduct(product);
        return mapper.map(customer, CustomerResponseDto.class);
    }

    @Override
    @Transactional
    public CustomerResponseDto changeStatus(Long id, boolean active) {
        Customer customer = findCustomer(id);
        customer.setActive(active);
        return mapper.map(customer, CustomerResponseDto.class);
    }
}
