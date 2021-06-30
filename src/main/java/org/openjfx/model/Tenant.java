package org.openjfx.model;

import java.util.Date;

public class Tenant extends Person {
    private Date dateOfAccomodation;

    public Tenant(String name, long phoneNumber, Date dateOfAccomodation) {
        super(name, phoneNumber);
        this.dateOfAccomodation = dateOfAccomodation;
    }

    public Date getDateOfAccomodation() {
        return dateOfAccomodation;
    }

    public void setDateOfAccomodation(Date dateOfAccomodation) {
        this.dateOfAccomodation = dateOfAccomodation;
    }

}
