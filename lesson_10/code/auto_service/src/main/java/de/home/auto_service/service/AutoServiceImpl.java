package de.home.auto_service.service;

import de.home.auto_service.entity.Auto;
import de.home.auto_service.exception.AutoNotFoundException;
import de.home.auto_service.reposirory.AutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {

    private final AutoRepository repository;

    @Override
    public List<Auto> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Auto> getByName(String name) {
        return getAll()
                .stream()
                .filter(auto -> auto.getBrand()
                        .equalsIgnoreCase(name))
                .toList();
    }

    @Override
    public Auto getById(Long id) {
//        return getAll()
//                .stream()
//                .filter(auto -> auto.getId().equals(id))
//                .findAny().orElseThrow(() -> new AutoNotFoundException("Auto not found with id " + id));
        return repository.findById(id);
    }

    @Override
    public Auto save(Auto auto) {
        return repository.save(auto);
    }

    @Override
    public Auto delete(Long id) {
        Auto auto = getById(id);
        if (auto == null) {
            throw new AutoNotFoundException("Auto not found with id " + id);
        }
        return repository.delete(auto);
    }
}
