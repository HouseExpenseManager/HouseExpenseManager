package org.openjfx.service;

import org.openjfx.dao.AdministratorDao;
import org.openjfx.model.Administrator;
import org.openjfx.model.Person;
import org.openjfx.util.InitApplication;

import java.io.IOException;
import java.util.List;


public class AdministratorService {

    public static AdministratorService adminService = null;
    public static AdministratorDao administratorDataAccessService = new AdministratorDao();
    private String currentNotification;

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

    public void notifyMe() throws IOException {
        Administrator administrator = InitApplication.initAdminCredentials();
        administrator.getNotifications().add(getCurrentNotification());
    }

    public String getCurrentNotification() {
        return currentNotification;
    }

    public void setCurrentNotification(String currentNotification) {
        this.currentNotification = currentNotification;
    }

}
