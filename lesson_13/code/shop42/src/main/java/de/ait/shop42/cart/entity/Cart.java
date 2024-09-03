package de.ait.shop42.cart.entity;

import de.ait.shop42.customer.entity.Customer;
import de.ait.shop42.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany
    @JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product.isActive()) {
            products.add(product);
        }

    }
    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }


}
