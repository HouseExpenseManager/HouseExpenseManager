package org.openjfx.dao;

import org.openjfx.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao implements DAO<Person> {

    private final List<Person> persons = new ArrayList<>();

    @Override
    public Person findByPhoneNumber(Integer phoneNumber) {
        for (Person person : persons) {
            if (person.getPhoneNumber().equals(phoneNumber)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> selectAll() {
        return persons;
    }

    @Override
    public Person delete(Integer phoneNumber) {
        Person user = findByPhoneNumber(phoneNumber);
        if (user != null) {
            persons.removeIf(user1 -> user1.equals(user));
            return user;
        } else return null;
    }


    @Override
    public Person insert(Person model) {
        persons.add(model);
        return model;
    }

    @Override
    public Person delete(Person model) {
        Person person = findByPhoneNumber(model.getPhoneNumber());
        if (person != null) {
            persons.remove(person);
        }
        return person;
    }
}


