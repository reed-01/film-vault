package org.danielreed.dao;

import org.danielreed.model.Film;

import java.util.List;

public interface CollectionDao {

    // An authenticated user can POST a film to a collection.
    public Film postFilmToCollection(Film film, int userId);

    // An authenticated user can GET a list of their film collection.
    public List<Film> getCollectionByUserId(int userId);

    // An authenticated user can DELETE a film from their collection.
    public int deleteFilmFromCollection(int userId, String filmId);
}