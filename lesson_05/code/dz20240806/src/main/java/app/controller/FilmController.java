package app.controller;

import app.entity.Film;
import app.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmController {
    private final FilmService service;

    @Autowired
    public FilmController(FilmService service) {
        this.service = service;
    }

    public List<Film> getAllFilms() {
        return service.findAll();
    }

    public Film getFilmById(Long id) {
        return service.findById(id);
    }
}
