package app.repository;

import app.entity.Film;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class FilmRepositoryImpl implements FilmRepository{
    private static Map<Long, Film> films = new HashMap<>();
    static {
        films.put(1L, new Film(1L,"The Shawshank Redemption", "Frank Darabont", 1994, "Drama"));
        films.put(2L, new Film(2L,"The Godfather", "Francis Ford Coppola", 1972, "Crime, Drama"));
        films.put(3L,new Film(3L, "The Dark Knight", "Christopher Nolan", 2008, "Action, Crime, Drama"));
        films.put(4L, new Film(4L, "Pulp Fiction", "Quentin Tarantino", 1994, "Crime, Drama"));
        films.put(5L, new Film(5L, "Schindler's List", "Steven Spielberg", 1993, "Biography, Drama, History"));
    }

    @Override
    public Film save(Film film) {
        return films.put(film.getId(), film);
    }

    @Override
    public List<Film> findAll() {
        return films
                .values()
                .stream()
                .toList();
    }

    @Override
    public void delete(Long id) {
        films.remove(id);
    }
}
