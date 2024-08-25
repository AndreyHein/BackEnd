package de.home.auto_service.service;

import de.home.auto_service.dto.AutoCreateDto;
import de.home.auto_service.dto.AutoResponseDto;
import de.home.auto_service.entity.Auto;

import java.util.List;

public interface AutoService {
    public List<AutoResponseDto> getAll();
    public List<AutoResponseDto> getByName(String name);
    public AutoResponseDto getById(Long id);
    public AutoResponseDto create(AutoCreateDto auto);
    public AutoResponseDto delete(Long id);
    public AutoResponseDto update(Long id, AutoCreateDto auto);
}
