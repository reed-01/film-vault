package org.danielreed.dao;

import org.danielreed.exception.DaoException;
import org.danielreed.model.Movie;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Movie getMovieByTitle(String title) {

        Movie movie = null;
        String sql = "SELECT imdb_id, title, release_year, rated, release_date, runtime, plot, language, country, awards, poster " +
                     "FROM movies " +
                     "WHERE title = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
            if (results.next()) {
                movie = mapRowToMovie(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return movie;
    }

    @Override
    public List<Movie> getMoviesByReleaseDate(LocalDate releaseDate) {

        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT imdb_id, title, release_year, rated, release_date, runtime, plot, language, country, awards, poster " +
                     "FROM movies " +
                     "WHERE release_date = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, releaseDate);
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return movies;
    }

    @Override
    public List<Movie> getMoviesByYear(String releaseYear) {

        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT imdb_id, title, release_year, rated, release_date, runtime, plot, language, country, awards, poster " +
                     "FROM movies " +
                     "WHERE release_year = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, releaseYear);
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return movies;
    }

    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();
        movie.setMovieId(rowSet.getString("imdb_id"));
        movie.setTitle(rowSet.getString("title"));
        movie.setReleaseYear(rowSet.getInt("release_year"));
        movie.setRated(rowSet.getString("rated"));

        if (rowSet.getDate("release_date") != null) {
            movie.setReleaseDate(rowSet.getDate("release_date").toLocalDate());
        }

        movie.setRuntime(rowSet.getInt("runtime"));
        movie.setPlot(rowSet.getString("plot"));
        movie.setLanguage(rowSet.getString("language"));
        movie.setCountry(rowSet.getString("country"));
        movie.setAwards(rowSet.getString("awards"));
        movie.setPoster(rowSet.getString("poster"));
        return movie;
    }
}
