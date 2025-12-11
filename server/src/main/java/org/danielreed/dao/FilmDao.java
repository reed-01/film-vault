package org.danielreed.dao;

import org.danielreed.model.Film;

public interface FilmDao {

    // As an unauthenticated user, they can search for a film by title.
    Film getFilmByTitle(String title);
}
