package org.danielreed.dao;

import org.danielreed.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie getMovieByTitle(String title) {
        return null;
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return null;
    }

    @Override
    public List<Movie> getMoviesByRating(String rating) {
        return null;
    }

    @Override
    public List<Movie> getMoviesByReleaseDate(String releaseDate) {
        return null;
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
