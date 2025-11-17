package org.danielreed.dao;

import org.danielreed.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcPersonDaoTest extends BaseDaoTest {

    private static final Person PERSON_1 = new Person(1, "person1");
    private static final Person PERSON_2 = new Person(2, "person2");
    private static final Person PERSON_3 = new Person(3, "person3");
    private static final Person PERSON_4 = new Person(4, "person4");

    private JdbcPersonDao dao;

    @BeforeEach
    public void setup() {
        dao = new JdbcPersonDao(dataSource);
    }

    @Test
    public void getAllPeople_returns_correct_people() {

        List<Person> people = dao.getAllPeople();

        assertEquals(4, people.size());

        assertPersonMatch(PERSON_1, people.get(0));
        assertPersonMatch(PERSON_2, people.get(1));
        assertPersonMatch(PERSON_3, people.get(2));
        assertPersonMatch(PERSON_4, people.get(3));
    }

    @Test
    public void getPersonById_with_valid_id_returns_correct_person() {

        Person person = dao.getPersonById(1);
        assertPersonMatch(PERSON_1, person);

        person = dao.getPersonById(2);
        assertPersonMatch(PERSON_2, person);
    }

    @Test
    public void getPersonById_with_invalid_id_returns_null_person() {

        Person person = dao.getPersonById(99);
        assertNull(person);
    }

    private void assertPersonMatch(Person expected, Person actual) {

        assertEquals(expected.getPersonId(), actual.getPersonId());
        assertEquals(expected.getName(), actual.getName());
    }
}
