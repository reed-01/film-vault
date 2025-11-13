package org.danielreed.dao;

import org.danielreed.model.Person;
import java.util.List;

public interface PersonDao {

    List<Person> getAllPeople();

    Person getPersonById(int personId);
}
