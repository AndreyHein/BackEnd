package app.service;

import app.entity.Film;

import java.util.List;

public interface FilmService {
    public List<Film> findAll();
    public Film findById(Long id);
    public Film save(Film film);
    public boolean delete(Long id);
}
