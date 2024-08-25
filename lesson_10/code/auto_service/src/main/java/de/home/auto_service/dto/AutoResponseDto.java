package de.home.auto_service.dto;

import de.home.auto_service.entity.Auto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class AutoResponseDto {
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private BigDecimal price;
    private String color;

    public static AutoResponseDto of(Auto auto) {
        return AutoResponseDto.builder()
                .id(auto.getId())
                .brand(auto.getBrand())
                .model(auto.getModel())
                .year(auto.getYear())
                .price(auto.getPrice())
                .color(auto.getColor())
                .build();
    }

    public static List<AutoResponseDto> of(List<Auto> listEntity) {
        return listEntity.stream()
                .map(AutoResponseDto::of)
                .toList();
    }
}
