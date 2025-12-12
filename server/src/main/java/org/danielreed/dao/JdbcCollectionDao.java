package org.danielreed.dao;

import org.danielreed.exception.DaoException;
import org.danielreed.model.Film;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcCollectionDao implements CollectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // As an authenticated user, they can SAVE a specific film to a collection.
    @Override
    public Film saveFilmToCollection(Film film, int userId) {

        String filmSql = "INSERT INTO films " +
                     "(imdb_id, film_type, title, release_year, rated, release_date, runtime, " +
                     "genre, director, actors, plot, language, country, awards, poster, imdb_rating)" +
                     "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            jdbcTemplate.update(filmSql, film.getFilmId(), film.getFilmType(), film.getTitle(), film.getReleaseYear(),
                    film.getRated(), film.getReleaseDate(), film.getRuntime(), film.getGenre(), film.getDirector(),
                    film.getActors(), film.getPlot(), film.getLanguage(), film.getCountry(),
                    film.getAwards(), film.getPoster(), film.getImdbRating());

            String userFilmSql = "INSERT INTO user_films " +
                                   "(user_id, imdb_id) " +
                                   "VALUES (?, ?);";
            jdbcTemplate.update(userFilmSql, userId, film.getFilmId());

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return film;
    }

    // As an authenticated user, they can REMOVE a specific film from their collection.
    @Override
    public int deleteFilmFromCollection(int userId, String filmId) {

        int numberOfRows = 0;

        String deleteFilmSql = "DELETE FROM user_films WHERE user_id = ? AND imdb_id = ?;";

        try {
            numberOfRows= jdbcTemplate.update(deleteFilmSql, userId, filmId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return numberOfRows;
    }

    // As an authenticated user, they can SEARCH in their collection for a list of films by RELEASE YEAR.

    // As an authenticated user, they can SEARCH in their collection for a list of films by GENRE.

    // As an authenticated user, they can SEARCH in their collection for a list of films by ACTOR.

    // As an authenticated user, they can SEARCH in their collection for a list of films by DIRECTOR.


}
