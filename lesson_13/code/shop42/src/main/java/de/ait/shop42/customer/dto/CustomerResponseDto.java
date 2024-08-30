package de.ait.shop42.customer.dto;

import de.ait.shop42.cart.dto.CartResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseDto {
    private Long id;
    private String name;
    private boolean active;
    private CartResponseDto cart;
}
