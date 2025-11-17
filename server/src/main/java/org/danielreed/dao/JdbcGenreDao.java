package org.danielreed.dao;


import org.danielreed.exception.DaoException;
import org.danielreed.model.Genre;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenresByMovie(String name) {

        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT g.name " +
                     "FROM movies m " +
                     "JOIN movie_genres mg ON m.movie_id = mg.movie_id " +
                     "JOIN genres g ON mg.genre_id = g.genre_id " +
                     "WHERE m.title = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            while (results.next()) {
                genres.add(mapRowToGenre(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }

        return genres;
    }

    @Override
    public List<Genre> getGenresByTelevisionShow(String name) {

        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT g.name " +
                     "FROM television_shows tv " +
                     "JOIN television_show_genres tvg ON tvg.television_show_id = tv.television_show_id " +
                     "JOIN genres g ON tvg.genre_id = g.genre_id " +
                     "WHERE tv.title = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            while (results.next()) {
                genres.add(mapRowToGenre(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }

        return genres;
    }

    private Genre mapRowToGenre(SqlRowSet rowSet) {
        Genre genre = new Genre();
        genre.setGenreId(rowSet.getInt("genre_id"));
        genre.setName(rowSet.getString("name"));
        return genre;
    }

}
