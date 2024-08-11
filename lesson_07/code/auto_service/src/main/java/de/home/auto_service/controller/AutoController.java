package de.home.auto_service.controller;

import de.home.auto_service.entity.Auto;
import de.home.auto_service.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AutoController {
    private final AutoService service;

    @GetMapping("api/autos")
    public List<Auto> getAutos(@RequestParam(name = "brand", required = false, defaultValue = "") String brand) {
        if (brand.equals("")) {
            return service.getAll();
        } else {
            return service.getByName(brand);
        }
    }

    @GetMapping("api/autos/{id}")
        public Auto getById(@PathVariable Long id) {
            return service.getById(id);
        }
}
