package org.openjfx.model;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private int numberOfTenants;
    private String city;
    private String adress;
    private List<Bill> bills = new ArrayList<>();
    private List<Tenant> tenants = new ArrayList<>();

    public Apartment(int numberOfTenants, String city, String adress) {
        this.numberOfTenants = numberOfTenants;
        this.city = city;
        this.adress = adress;
    }

    public int getNumberOfTenants() {
        return numberOfTenants;
    }

    public void setNumberOfTenants(int numberOfTenants) {
        this.numberOfTenants = numberOfTenants;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }
}
