package de.ait.shop42.customer.repository;

import de.ait.shop42.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
