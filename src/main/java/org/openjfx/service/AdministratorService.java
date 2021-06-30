package org.openjfx.service;

import org.openjfx.dao.AdministratorDao;
import org.openjfx.model.Administrator;
import org.openjfx.model.Person;

import java.util.List;


public class AdministratorService {

    public static AdministratorService adminService = null;
    public static AdministratorDao administratorDataAccessService = new AdministratorDao();

    private AdministratorService(AdministratorDao administratorDataAccessService) {
        AdministratorService.administratorDataAccessService = administratorDataAccessService;
    }
    public static AdministratorService getInstance() {
        if (adminService == null) {
            adminService = new AdministratorService(administratorDataAccessService);
        }
        return adminService;
    }

    public Person findByPhoneNumber(Integer phoneNumber) {
        return administratorDataAccessService.findByPhoneNumber(phoneNumber);
    }


    public void insert(Administrator model) {
        administratorDataAccessService.insert(model);
    }

    public List<Administrator> selectAll() {
        return administratorDataAccessService.selectAll();
    }

}
