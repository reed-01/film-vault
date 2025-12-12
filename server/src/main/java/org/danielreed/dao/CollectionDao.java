package org.danielreed.dao;

import org.danielreed.model.Film;

import java.util.List;

public interface CollectionDao {

    // As an authenticated user, they can SAVE a specific film to a collection.
    public Film saveFilmToCollection(Film film, int userId);

    // As an authenticated user, they can REMOVE a specific film from their collection.
    public int deleteFilmFromCollection(int userId, String filmId);

    // As an authenticated user, in their collection they can GET a list of films by TYPE.
    public List<Film> getCollectionFilmsByType(String filmType, int userId);

    // As an authenticated user, in their collection they can GET a list of films by GENRE.
    public List<Film> getCollectionFilmsByGenre(String genre, int userId);

    // As an authenticated user, in their collection they can GET a list of films by RATED.
    public List<Film> getCollectionFilmsByRated(String rated, int userId);

    // As an authenticated user, in their collection they can GET a list of films by RELEASE YEAR.
    public List<Film> getCollectionFilmsByReleaseYear(String releaseYear, int userId);

    // As an authenticated user, in their collection they can GET a list of films by ACTOR.
    public List<Film> getCollectionFilmsByActors(String actors, int userId);

    // As an authenticated user, in their collection they can GET a list of films by DIRECTOR.
    public List<Film> getCollectionFilmsByDirector(String director, int userId);
}
