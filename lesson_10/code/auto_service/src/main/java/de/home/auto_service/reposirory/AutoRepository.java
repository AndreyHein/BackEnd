package de.home.auto_service.reposirory;

import de.home.auto_service.entity.Auto;

import java.util.List;

public interface AutoRepository {
    List<Auto> findAll();
    Auto save(Auto auto);
    Auto delete(Long id);
    Auto findById(Long id);
}
