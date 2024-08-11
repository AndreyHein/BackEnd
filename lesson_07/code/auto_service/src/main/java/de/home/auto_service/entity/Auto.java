package de.home.auto_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
public class Auto {
    @Setter
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String vin;
    private BigDecimal price;
    private String color;
}
