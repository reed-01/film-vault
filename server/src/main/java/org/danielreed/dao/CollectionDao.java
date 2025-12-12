package org.danielreed.dao;

import org.danielreed.model.Film;

public interface CollectionDao {

    // As an authenticated user, they can SAVE a specific film to a collection.
    public Film saveFilmToCollection(Film film, int userId);

    // As an authenticated user, they can REMOVE a specific film from their collection.
    public int deleteFilmFromCollection(int userId, String filmId);

    // As an authenticated user, they can SEARCH in their collection for a list of films by RELEASE YEAR.

    // As an authenticated user, they can SEARCH in their collection for a list of films by GENRE.

    // As an authenticated user, they can SEARCH in their collection for a list of films by ACTOR.

    // As an authenticated user, they can SEARCH in their collection for a list of films by DIRECTOR.

}
