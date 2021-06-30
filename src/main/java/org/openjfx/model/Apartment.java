package org.openjfx.model;

import java.util.ArrayList;
import java.util.List;

public class Apartment {

    private int numberOfTenants;
    private String city;
    private String address;
    private List<Bill> bills = new ArrayList<>();
    private List<Tenant> tenants = new ArrayList<>();

    public Apartment(int numberOfTenants, String city, String address) {
        this.numberOfTenants = numberOfTenants;
        this.city = city;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
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

    @Override
    public String toString() {
        return "Apartment{" +
                "numberOfTenants=" + numberOfTenants +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", bills=" + bills +
                ", tenants=" + tenants +
                '}';
    }
}

