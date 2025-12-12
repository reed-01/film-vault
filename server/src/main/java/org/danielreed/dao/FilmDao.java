package org.danielreed.dao;

import org.danielreed.model.Film;

public interface FilmDao {

    // An unauthenticated user can GET a film by TITLE.
    Film getFilmByTitle(String title);
}
