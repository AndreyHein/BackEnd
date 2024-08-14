package de.home.auto_service.reposirory;

import de.home.auto_service.entity.Auto;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoRepositoryImpl implements AutoRepository {

    List<Auto> list = new ArrayList<>(List.of(
            new Auto(1L, "Toyota", "Camry", 2022, "1HGCM82633A123456", new BigDecimal("30000.00"), "Red"),
            new Auto(2L, "Mercedes-Benz", "E-Class", 2023, "WDDZF4KB9HA123456", new BigDecimal("60000.00"), "Blue"),
            new Auto(3L, "Nissan", "Maxima", 2019, "1N4AA6AP6HC123456", new BigDecimal("30000.00"), "Black"),
            new Auto(4L, "Toyota", "Corolla", 2021, "2T1BR32E54C123456", new BigDecimal("20000.00"), "Blue"),
            new Auto(5L, "Honda", "Civic", 2020, "19XFC2F59HE123456", new BigDecimal("20000.00"), "Black"),
            new Auto(6L, "BMW", "3 Series", 2022, "WBA8E9G51G1234567", new BigDecimal("50000.00"), "Silver"),
            new Auto(7L, "Nissan", "Altima", 2020, "1N4AL3AP8JC123456", new BigDecimal("25000.00"), "Red"),
            new Auto(8L, "Honda", "Accord", 2019, "1HGCV1F38KA123456", new BigDecimal("27000.00"), "White"),
            new Auto(9L, "Mercedes-Benz", "C-Class", 2022, "WDDGF8AB8EA123456", new BigDecimal("55000.00"), "Green"),
            new Auto(10L, "BMW", "5 Series", 2021, "WBAJA5C57L1234567", new BigDecimal("55000.00"), "Gray")));

    @Override
    public List<Auto> findAll() {
        return new ArrayList<>(list);
    }

    @Override
    public Auto save(Auto entity) {
        long max = list.stream()
                .mapToLong(a -> a.getId().longValue())
                .max().getAsLong();
        entity.setId(max + 1);
        list.add(entity);
        return entity;
    }

    @Override
    public Auto delete(Auto entity) {
        list.remove(entity);
        return entity;
    }
}
