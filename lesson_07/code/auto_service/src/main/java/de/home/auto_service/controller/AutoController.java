package de.home.auto_service.controller;

import de.home.auto_service.entity.Auto;
import de.home.auto_service.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AutoController {
    private final AutoService service;

    @GetMapping("/autos")
    public List<Auto> getAutos(@RequestParam(name = "brand", required = false, defaultValue = "") String brand) {
        if (brand.equals("")) {
            return service.getAll();
        } else {
            return service.getByName(brand);
        }
    }

    @GetMapping("/autos/{id}")
        public Auto getById(@PathVariable Long id) {
            return service.getById(id);
        }

    @PostMapping("/autos")
    public Auto addAuto(@RequestBody Auto auto) {
    return service.save(auto);
    }

    @DeleteMapping("/autos/{id}")
    public Auto delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
