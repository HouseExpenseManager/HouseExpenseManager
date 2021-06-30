package org.openjfx.service;

import org.openjfx.model.Person;
import org.openjfx.model.Tenant;
import org.openjfx.util.InitApplication;

import java.io.IOException;
import java.util.List;

public class LoginService {

    public static LoginService loginService = null;
    private static final PersonService personService = PersonService.getInstance();
    private static final TenantService tenantService = TenantService.getInstance();
    private int idGrasper;

    public static LoginService getInstance() {
        if (loginService == null) {
            loginService = new LoginService();
        }
        return loginService;
    }

    public String logIn(Person formUser) throws IOException {
        List<Tenant> tenants = tenantService.selectAll();
        tenants.addAll(InitApplication.loadTenantCredentials());
        tenants.forEach(System.out::println);
        Person myUser = personService.findByPhoneNumber(formUser.getPhoneNumber());
        if (myUser == null) {
            return null;
        }
        setIdGrasper(formUser.getPhoneNumber());
        if (myUser.equals(InitApplication.initAdminCredentials())) {
            return "ADMIN";
        }
        for (Tenant tenant : tenants) {
            if (checkCondition(tenantService.findByPhoneNumber(tenant.getPhoneNumber()), formUser)) {
                return "TENANT";
            }
        }
        return null;
    }

    private static boolean checkCondition(Person original, Person toEvaluate) {
        return original.getPhoneNumber().equals(toEvaluate.getPhoneNumber()) && original.getUserName().equals(toEvaluate.getUserName());
    }

    public void setIdGrasper(int idGrasper) {
        this.idGrasper = idGrasper;
    }

    public int getIdGrasper() {
        return idGrasper;
    }
}
