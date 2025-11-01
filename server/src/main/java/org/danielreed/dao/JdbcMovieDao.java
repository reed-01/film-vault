package org.danielreed.dao;

import org.danielreed.exception.DaoException;
import org.danielreed.model.Movie;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id, title, genre, rating, release_date, description, cover_image " +
                     "FROM movies " +
                     "ORDER BY movie_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return movies;
    }

    @Override
    public Movie getMovieByTitle(String title) {

        Movie movie = null;
        String sql = "SELECT movie_id, title, genre, rating, release_date, description, cover_image " +
                     "FROM movies " +
                     "WHERE title = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            if (results.next()) {
                movie = mapRowToMovie(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return movie;
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {

        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id, title, genre, rating, release_date, description, cover_image " +
                     "FROM movies " +
                     "WHERE genre = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return movies;
    }

    @Override
    public List<Movie> getMoviesByRating(String rating) {

        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id, title, genre, rating, release_date, description, cover_image " +
                     "FROM movies " +
                     "WHERE rating = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return movies;
    }

    @Override
    public List<Movie> getMoviesByReleaseDate(String releaseDate) {

        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id, title, genre, rating, release_date, description, cover_image" +
                     "FROM movies " +
                     "WHERE release_date = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
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
        movie.setMovieId(rowSet.getInt("movie_id"));
        movie.setTitle(rowSet.getString("title"));
        movie.setGenre(rowSet.getString("genre"));
        movie.setRating(rowSet.getString("rating"));
        movie.setReleaseDate(rowSet.getString("release_date"));
        movie.setDescription(rowSet.getString("description"));
        movie.setCoverImage(rowSet.getString("cover_image"));
        return movie;
    }
}
