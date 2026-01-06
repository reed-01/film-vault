package org.danielreed.dao;

import org.danielreed.exception.DaoException;
import org.danielreed.model.Film;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Film postFilmToCollection(Film film, int userId) {

        /* imdb_id is the primary key for films, so we first check for its
           existence to allow multiple users to save the same film.
           The user_films join table enforces one film per user and throws
           an error if a user tries to save the same film twice. */

        String checkFilmSql = "SELECT imdb_id " +
                              "FROM films " +
                              "WHERE imdb_id = ?;";

        String insertFilmSql = "INSERT INTO films " +
                               "(imdb_id, film_type, title, release_year, rated, release_date, runtime, " +
                               "genre, director, actors, plot, language, country, awards, poster, imdb_rating) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        String insertUserFilmSql = "INSERT INTO user_films " +
                                   "(user_id, imdb_id) " +
                                   "VALUES (?, ?);";

        try {
            // 1.) check if film already exists
            SqlRowSet filmExistsResults = jdbcTemplate.queryForRowSet(checkFilmSql, film.getFilmId());

            // 2.) if the film does NOT exist, insert it
            if (!filmExistsResults.next()) {
                jdbcTemplate.update(insertFilmSql, film.getFilmId(), film.getFilmType(), film.getTitle(), film.getReleaseYear(),
                        film.getRated(), film.getReleaseDate(), film.getRuntime(), film.getGenre(), film.getDirector(),
                        film.getActors(), film.getPlot(), film.getLanguage(), film.getCountry(),
                        film.getAwards(), film.getPoster(), film.getImdbRating());
            }

            // 3.) link film to user collection
            jdbcTemplate.update(insertUserFilmSql, userId, film.getFilmId());

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return film;
    }

    @Override
    public List<Film> getCollectionByUserId(int userId) {

        List<Film> films = new ArrayList<>();

        String sql = "SELECT f.imdb_id, f.film_type, f.title, f.release_year, f.rated, f.release_date, f.runtime, " +
                     "f.genre, f.director, f.actors, f.plot, f.language, f.country, f.awards, f.poster, f.imdb_rating " +
                     "FROM films f " +
                     "JOIN user_films uf ON f.imdb_id = uf.imdb_id " +
                     "WHERE uf.user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

            while (results.next()) {
                films.add(mapRowToFilm(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return films;
    }

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

    private Film mapRowToFilm (SqlRowSet rowSet) {

        Film film = new Film();

        film.setFilmId(rowSet.getString("imdb_id"));
        film.setFilmType(rowSet.getString("film_type"));
        film.setTitle(rowSet.getString("title"));
        film.setReleaseYear(rowSet.getString("release_year"));
        film.setRated(rowSet.getString("rated"));

        if (rowSet.getString("release_date") != null) {
            film.setReleaseDate(rowSet.getString("release_date"));
        }

        film.setRuntime(rowSet.getString("runtime"));
        film.setGenre(rowSet.getString("genre"));
        film.setDirector(rowSet.getString("director"));
        film.setActors(rowSet.getString("actors"));
        film.setPlot(rowSet.getString("plot"));
        film.setLanguage(rowSet.getString("language"));
        film.setCountry(rowSet.getString("country"));
        film.setAwards(rowSet.getString("awards"));
        film.setPoster(rowSet.getString("poster"));
        film.setImdbRating(rowSet.getString("imdb_rating"));

        return film;
    }
}
