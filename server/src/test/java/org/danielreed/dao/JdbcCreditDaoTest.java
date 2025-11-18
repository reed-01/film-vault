package org.danielreed.dao;

import org.danielreed.model.Credit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcCreditDaoTest extends BaseDaoTest {

    private static final Credit CREDIT_1 = new Credit(1, "person1", "role1", "character1");
    private static final Credit CREDIT_2 = new Credit(2, "person2", "role2", "character2");

    private JdbcCreditDao dao;

    @BeforeEach
    public void setup() {
        dao = new JdbcCreditDao(dataSource);
    }

    @Test
    public void getCreditsForMovie_only_returns_list_of_credits_for_valid_movie() {

        List<Credit> credits = dao.getCreditsForMovie(1);

        assertEquals(2, credits.size());
        assertCreditsMatch(CREDIT_1, credits.get(0));
        assertCreditsMatch(CREDIT_2, credits.get(1));
    }

    @Test
    public void getCreditsForMovie_only_returns_empty_list_of_credits_for_invalid_movie() {

        List<Credit> credits = dao.getCreditsForMovie(99);
        assertTrue(credits.isEmpty());
    }

    @Test
    public void getCreditsForTelevisionShow_only_returns_list_of_credits_for_valid_television_show() {

        List<Credit> credits = dao.getCreditsForTelevisionShow(1);

        assertEquals(2, credits.size());
        assertCreditsMatch(CREDIT_1, credits.get(0));
        assertCreditsMatch(CREDIT_2, credits.get(1));
    }

    @Test
    public void getCreditsForTelevisionShow_only_returns_empty_list_of_credits_for_invalid_television_show() {

        List<Credit> credits = dao.getCreditsForTelevisionShow(99);
        assertTrue(credits.isEmpty());
    }

    private void assertCreditsMatch(Credit expected, Credit actual) {

        assertEquals(expected.getPersonId(), actual.getPersonId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getCreditRole(), actual.getCreditRole());
        assertEquals(expected.getCharacterName(), actual.getCharacterName());
    }
}
