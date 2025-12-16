package org.danielreed.dao;

import org.danielreed.model.Film;

import java.util.List;

public interface CollectionDao {

    // An authenticated user can POST a film to a collection.
    public Film postFilmToCollection(Film film, int userId);

    // An authenticated user can GET a list of their film collection.
    public List<Film> getCollectionByUserId(int userId);

    // An authenticated user can GET a list of films in their collection by TYPE.
    public List<Film> getCollectionFilmsByType(String filmType, int userId);

    // An authenticated user can GET a list of films in their collection by GENRE.
    public List<Film> getCollectionFilmsByGenre(String genre, int userId);

    // An authenticated user can GET a list of films in their collection by RATED.
    public List<Film> getCollectionFilmsByRated(String rated, int userId);

    // An authenticated user can GET a list of films in their collection by RELEASE YEAR.
    public List<Film> getCollectionFilmsByReleaseYear(String releaseYear, int userId);

    // An authenticated user can GET a list of films in their collection by ACTOR.
    public List<Film> getCollectionFilmsByActor(String actors, int userId);

    // An authenticated user can GET a list of films in their collection by DIRECTOR.
    public List<Film> getCollectionFilmsByDirector(String director, int userId);

    // An authenticated user can DELETE a film from their collection.
    public int deleteFilmFromCollection(int userId, String filmId);
}