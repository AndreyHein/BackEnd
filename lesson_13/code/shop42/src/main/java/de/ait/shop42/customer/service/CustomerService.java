package de.ait.shop42.customer.service;

import de.ait.shop42.customer.dto.CustomerRequestDto;
import de.ait.shop42.customer.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto dto);
    List<CustomerResponseDto> getCustomers();
    CustomerResponseDto getCustomerById(Long id);
    CustomerResponseDto addProductToCart(Long customerId, Long productId);
    CustomerResponseDto removeProductFromCart(Long customerId, Long productId);
    CustomerResponseDto changeStatus(Long id, boolean active);
}
