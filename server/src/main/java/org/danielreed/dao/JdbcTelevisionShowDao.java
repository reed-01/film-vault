package org.danielreed.dao;

import org.danielreed.exception.DaoException;
import org.danielreed.model.TelevisionShow;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTelevisionShowDao implements TelevisionShowDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTelevisionShowDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public TelevisionShow getTelevisionShowByTitle(String title) {

        TelevisionShow televisionShow = null;

        String sql = "SELECT imdb_id, type, title, release_year, rated, release_date, runtime, plot, language, country, awards, poster " +
                     "FROM television_shows " +
                     "WHERE title = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
            if (results.next()) {
                televisionShow = mapRowToTelevisionShow(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return televisionShow;
    }

    @Override
    public List<TelevisionShow> getTelevisionShowsByReleaseDate(String releaseDate) {

        List<TelevisionShow> televisionShows = new ArrayList<>();

        String sql = "SELECT imdb_id, type, title, release_year, rated, release_date, runtime, plot, language, country, awards, poster " +
                     "FROM television_shows " +
                     "WHERE release_date = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, releaseDate);
            while (results.next()) {
                televisionShows.add(mapRowToTelevisionShow(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return televisionShows;
    }

    @Override
    public List<TelevisionShow> getTelevisionShowsByYear(String releaseYear) {

        List<TelevisionShow> televisionShows = new ArrayList<>();

        String sql = "SELECT imdb_id, type, title, release_year, rated, release_date, runtime, plot, language, country, awards, poster " +
                     "FROM television_shows " +
                     "WHERE release_year = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, releaseYear);
            while (results.next()) {
                televisionShows.add(mapRowToTelevisionShow(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return televisionShows;
    }

    private TelevisionShow mapRowToTelevisionShow(SqlRowSet rowSet) {

        TelevisionShow televisionShow = new TelevisionShow();

        televisionShow.setTelevisionShowId(rowSet.getString("imdb_id"));
        televisionShow.setType(rowSet.getString("type"));
        televisionShow.setTitle(rowSet.getString("title"));
        televisionShow.setReleaseYear(rowSet.getString("release_year"));
        televisionShow.setRated(rowSet.getString("rated"));
        televisionShow.setReleaseDate(rowSet.getString("release_date"));
        televisionShow.setRuntime(rowSet.getString("runtime"));
        televisionShow.setPlot(rowSet.getString("plot"));
        televisionShow.setLanguage(rowSet.getString("language"));
        televisionShow.setCountry(rowSet.getString("country"));
        televisionShow.setAwards(rowSet.getString("awards"));
        televisionShow.setPoster(rowSet.getString("poster"));

        return televisionShow;
    }
}

