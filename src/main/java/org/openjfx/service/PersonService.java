package org.openjfx.service;


import org.openjfx.dao.PersonDao;
import org.openjfx.model.Person;
import org.openjfx.model.Tenant;

import java.util.List;

public class PersonService {

    private static PersonService userService = null;
    public static PersonDao userDataAccessService = new PersonDao();

    private PersonService(PersonDao userDataAccessService) {
        PersonService.userDataAccessService = userDataAccessService;
    }

    public static PersonService getInstance() {
        if (userService == null) {
            userService = new PersonService(userDataAccessService);
        }
        return userService;
    }

    public Person findByPhoneNumber(Integer phoneNumber) {
        return userDataAccessService.findByPhoneNumber(phoneNumber);
    }

    public void insert(Person model) {
        userDataAccessService.insert(model);
    }

    public List<Person> selectAll() {
        return userDataAccessService.selectAll();
    }

    public Person delete(Person model) {
        return userDataAccessService.delete(model);
    }
}
