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
    public List<TelevisionShow> getAllTelevisionShows() {

        List<TelevisionShow> televisionShows = new ArrayList<>();
        String sql = "SELECT television_show_id, title, release_date, overview, poster_path " +
                     "FROM television_shows;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                televisionShows.add(mapRowToTelevisionShow(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return televisionShows;
    }

    @Override
    public TelevisionShow getTelevisionShowsByTitle(String title) {

        TelevisionShow televisionShow = null;
        String sql = "SELECT television_show_id, title, release_date, overview, poster_path " +
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
        String sql = "SELECT television_show_id, title, release_date, overview, poster_path " +
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

    private TelevisionShow mapRowToTelevisionShow(SqlRowSet rowSet) {
        TelevisionShow televisionShow = new TelevisionShow();
        televisionShow.setTelevisionShowId(rowSet.getInt("television_show_id"));
        televisionShow.setTitle(rowSet.getString("title"));
        televisionShow.setReleaseDate(rowSet.getString("release_date"));
        televisionShow.setOverview(rowSet.getString("overview"));
        televisionShow.setPosterPath(rowSet.getString("poster_path"));
        return televisionShow;
    }
}

