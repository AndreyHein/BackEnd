package app.repository;

import app.entity.Film;

import java.util.List;

public interface FilmRepository {
    public Film save(Film film);
    public List<Film> findAll();
    public void delete(Long id);
}
