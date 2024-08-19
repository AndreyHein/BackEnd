package de.home.auto_service.reposirory;

import de.home.auto_service.entity.Auto;
import de.home.auto_service.exception.AutoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AutoRepositoryJDBCImpl implements AutoRepository{

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    private static final RowMapper<Auto> AUTO_ROW_MAPPER = (rs, rowNum) -> {
        Long id = rs.getLong("id");
        String brand = rs.getString("brand");
        String model = rs.getString("model");
        int year = rs.getInt("year");
        String vin = rs.getString("vin");
        BigDecimal price = rs.getBigDecimal("price");
        String color = rs.getString("color");

        return new Auto(id, brand, model, year, vin, price, color);
    };

    @Override
    public List<Auto> findAll() {
        String sql = "SELECT * FROM auto";
        return jdbcTemplate.query(sql, AUTO_ROW_MAPPER);
    }

    @Override
    public Auto save(Auto auto) {
        if (auto.getId() == null) {
            return create(auto);
        }
        return update(auto);
    }

    public Auto create(Auto auto) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id")
                .withTableName("auto");
/*
        Map<String, Object> params = new HashMap<>();
        params.put("brand", auto.getBrand());
        params.put("model", auto.getModel());
        params.put("year", auto.getYear());
        params.put("vin", auto.getVin());
        params.put("price", auto.getPrice());
        params.put("color", auto.getColor());
*/
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("brand", auto.getBrand())
                .addValue("model", auto.getModel())
                .addValue("year", auto.getYear())
                .addValue("vin", auto.getVin())
                .addValue("price", auto.getPrice())
                .addValue("color", auto.getColor());

        long newID = jdbcInsert.executeAndReturnKey(params).longValue();
        auto.setId(newID);
        return auto;
    }

    private Auto update(Auto auto) {
        Auto existingAuto = findById(auto.getId());
        if (existingAuto == null) {
            throw new RuntimeException("Auto not found with ID: " + auto.getId());
        }

        if (auto.getBrand() != null) {
            existingAuto.setBrand(auto.getBrand());
        }
        if (auto.getModel() != null) {
            existingAuto.setModel(auto.getModel());
        }
        if (auto.getYear() != null) {
            existingAuto.setYear(auto.getYear());
        }
        if (auto.getVin() != null) {
            existingAuto.setVin(auto.getVin());
        }
        if (auto.getPrice() != null) {
            existingAuto.setPrice(auto.getPrice());
        }
        if (auto.getColor() != null) {
            existingAuto.setColor(auto.getColor());
        }

        String sql = "UPDATE auto SET brand = ?, model = ?, year = ?, vin = ?, price = ?, color = ? WHERE id = ?";
        int update = jdbcTemplate.update(
                sql,
                existingAuto.getBrand(),
                existingAuto.getModel(),
                existingAuto.getYear(),
                existingAuto.getVin(),
                existingAuto.getPrice(),
                existingAuto.getColor(),
                auto.getId()
        );
        if (update == 0) {
            throw new RuntimeException("Update failed");
        }
        return existingAuto;
    }

    @Override
    public Auto delete(Auto auto) {
        String sql = "DELETE FROM auto WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, auto.getId());

        if (rowsAffected == 0) {
            throw new AutoNotFoundException("Auto not found with id " + auto.getId());
        }
        return auto;
    }

    @Override
    public Auto findById(Long id) {
        String sql = "SELECT * FROM auto WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Auto.class));
        } catch (RuntimeException e) {
            throw new AutoNotFoundException("Auto not found with id " + id);
        }
    }
}
