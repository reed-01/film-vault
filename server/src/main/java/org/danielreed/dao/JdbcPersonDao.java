package org.danielreed.dao;

import org.danielreed.exception.DaoException;
import org.danielreed.model.Person;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getAllPeople() {

        List<Person> people = new ArrayList<>();
        String sql = "SELECT person_id, name " +
                     "FROM people;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                people.add(mapRowToPerson(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return people;
    }

    @Override
    public Person getPersonById(int personId) {

        Person person = null;
        String sql = "SELECT person_id, name " +
                     "FROM people " +
                     "WHERE person_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, personId);
            if (results.next()) {
                person = mapRowToPerson(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return person;
    }

    private Person mapRowToPerson(SqlRowSet rowSet) {
        Person person = new Person();
        person.setPersonId(rowSet.getInt("person_id"));
        person.setName(rowSet.getString("name"));
        return person;
    }
}
