package de.home.auto_service.service;

import de.home.auto_service.dto.AutoCreateDto;
import de.home.auto_service.dto.AutoResponseDto;
import de.home.auto_service.entity.Auto;
import de.home.auto_service.exception.AutoNotFoundException;
import de.home.auto_service.reposirory.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    private final AutoRepository repository;

    @Autowired
    public AutoServiceImpl(@Qualifier("actualRepository") AutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AutoResponseDto> getAll() {
        return AutoResponseDto.of(repository.findAll());
    }

    @Override
    public List<AutoResponseDto> getByName(String name) {
        return getAll()
                .stream()
                .filter(auto -> auto.getBrand()
                .equalsIgnoreCase(name))
                .toList();
    }

    @Override
    public AutoResponseDto getById(Long id) {
//        return getAll()
//                .stream()
//                .filter(auto -> auto.getId().equals(id))
//                .findAny().orElseThrow(() -> new AutoNotFoundException("Auto not found with id " + id));
        return AutoResponseDto.of(repository.findById(id));
    }

    @Override
    public AutoResponseDto create(AutoCreateDto autoDto) {
        Auto newAuto = new Auto(null, autoDto.getBrand(), autoDto.getModel(), autoDto.getYear(),
                autoDto.getVin(), autoDto.getPrice(), autoDto.getColor());
        return AutoResponseDto.of(repository.save(newAuto));
    }

    @Override
    public AutoResponseDto delete(Long id) {
        AutoResponseDto auto = getById(id);
        if (auto == null) {
            throw new AutoNotFoundException("Auto not found with id " + id);
        }
        return AutoResponseDto.of(repository.delete(id));
    }

    @Override
    public AutoResponseDto update(Long id, AutoCreateDto dtoAuto) {
        Auto auto = new Auto(id, dtoAuto.getBrand(), dtoAuto.getModel(), dtoAuto.getYear(), dtoAuto.getVin(), dtoAuto.getPrice(), dtoAuto.getColor());
        return AutoResponseDto.of(repository.save(auto));
    }
}
