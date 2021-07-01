package org.openjfx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tenant extends Person implements Serializable {

    private List<Bill> bills = new ArrayList<>();
    private Date dateOfAccommodation;

    public Tenant(String userName, Integer phoneNumber) {
        super(userName, phoneNumber);
    }

    public Tenant(String userName, Integer phoneNumber, Date dateOfAccommodation) {
        super(userName, phoneNumber);
        this.dateOfAccommodation = dateOfAccommodation;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Date getDateOfAccommodation() {
        return dateOfAccommodation;
    }

    public void setDateOfAccommodation(Date dateOfAccommodation) {
        this.dateOfAccommodation = dateOfAccommodation;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "bills=" + bills +
                ", dateOfAccommodation=" + dateOfAccommodation +
                '}';
    }
}
