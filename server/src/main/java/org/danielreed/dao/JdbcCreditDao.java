//package org.danielreed.dao;
//
//
//import org.danielreed.exception.DaoException;
//import org.danielreed.model.Credit;
//import org.springframework.jdbc.CannotGetJdbcConnectionException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.rowset.SqlRowSet;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class JdbcCreditDao implements CreditDao {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public JdbcCreditDao(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public List<Credit> getCreditsForMovie(int movieId) {
//
//        List<Credit> credits = new ArrayList<>();
//        String sql = "SELECT mc.movie_id, mc.person_id, mc.credit_role, p.name, mc.character_name " +
//                     "FROM movie_credits mc " +
//                     "JOIN people p ON mc.person_id = p.person_id " +
//                     "JOIN movies m ON mc.movie_id = m.movie_id " +
//                     "WHERE mc.movie_id = ? " +
//                     "ORDER BY mc.person_id;";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, movieId);
//            while (results.next()) {
//                credits.add(mapRowToCredit(results));
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//
//        return credits;
//    }
//
//    @Override
//    public List<Credit> getCreditsForTelevisionShow(int televisionShowId) {
//
//        List<Credit> credits = new ArrayList<>();
//        String sql = "SELECT tsc.television_show_id, tsc.person_id, tsc.credit_role, p.name, tsc.character_name " +
//                     "FROM television_show_credits tsc " +
//                     "JOIN people p ON tsc.person_id = p.person_id " +
//                     "JOIN television_shows ts ON tsc.television_show_id = ts.television_show_id " +
//                     "WHERE tsc.television_show_id = ? " +
//                     "ORDER BY tsc.person_id;";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, televisionShowId);
//            while (results.next()) {
//                credits.add(mapRowToCredit(results));
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//
//        return credits;
//    }
//
//    private Credit mapRowToCredit(SqlRowSet rowSet) {
//        Credit credit = new Credit();
//        credit.setPersonId(rowSet.getInt("person_id"));
//        credit.setName(rowSet.getString("name"));
//        credit.setCreditRole(rowSet.getString("credit_role"));
//        credit.setCharacterName(rowSet.getString("character_name"));
//        return credit;
//    }
//}
