package org.danielreed.dao;

import org.danielreed.exception.DaoException;
import org.danielreed.model.Film;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcFilmDao implements FilmDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcFilmDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Film getFilmByTitle(String title) {

        Film film = null;

        String sql = "SELECT imdb_id, film_type, title, release_year, rated, release_date, runtime, genre, director, actors, plot, language, country, awards, poster, imdb_rating " +
                     "FROM films " +
                     "WHERE title = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
            if (results.next()) {
                film = mapRowToFilm(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return film;
    }

    private Film mapRowToFilm(SqlRowSet rowSet) {

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
