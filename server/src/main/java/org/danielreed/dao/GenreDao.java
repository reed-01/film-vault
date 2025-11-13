package org.danielreed.dao;

import org.danielreed.model.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getGenresByMovie(String name);

    List<Genre> getGenresByTelevisionShow(String name);
}
