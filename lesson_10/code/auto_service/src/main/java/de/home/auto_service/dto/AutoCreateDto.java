package de.home.auto_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Getter
public class AutoCreateDto {
    private String brand;
    private String model;
    private Integer year;
    private String vin;
    private BigDecimal price;
    private String color;
}
