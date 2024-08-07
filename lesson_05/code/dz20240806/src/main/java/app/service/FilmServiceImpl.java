package app.service;

import app.entity.Film;
import app.exception.FilmNotFoundException;
import app.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmServiceImpl implements FilmService {
    private final FilmRepository repository;

    @Autowired
    public FilmServiceImpl(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Film> findAll() {
        return repository.findAll();
    }

    @Override
    public Film findById(Long id) {
        return findAll()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findAny().orElseThrow(() -> new FilmNotFoundException());
    }

    @Override
    public Film save(Film film) {
        repository.save(film);
        return film;
    }

    @Override
    public boolean delete(Long id) {
        Film existingFilm = findById(id);
        if (existingFilm != null) {
            repository.delete(id);
            return true;
        }
        return false;
    }
}
