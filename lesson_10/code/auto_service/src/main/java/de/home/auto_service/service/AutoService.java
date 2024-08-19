package de.home.auto_service.service;

import de.home.auto_service.entity.Auto;

import java.util.List;

public interface AutoService {
    public List<Auto> getAll();
    public List<Auto> getByName(String name);
    public Auto getById(Long id);
    public Auto save(Auto auto);
    public Auto delete(Long id);
}
