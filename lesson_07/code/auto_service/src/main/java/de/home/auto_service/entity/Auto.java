package de.home.auto_service.entity;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class Auto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String vin;
    private BigDecimal price;
    private String color;
}
