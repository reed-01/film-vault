package org.danielreed.dao;

import org.danielreed.model.Film;

import java.util.List;

public interface FilmDao {

    Film getFilmByTitle(String title);

    List<Film> getFilmsByYear(String releaseYear);
}
