package org.openjfx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tenant extends Person implements Serializable {

    private List<String> notifications = new ArrayList<>();
    private Date dateOfAccommodation;

    public Tenant(String userName, Integer phoneNumber) {
        super(userName, phoneNumber);
    }

    public Tenant(String userName, Integer phoneNumber, Date dateOfAccommodation) {
        super(userName, phoneNumber);
        this.dateOfAccommodation = dateOfAccommodation;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
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
                "notifications=" + notifications +
                ", dateOfAccommodation=" + dateOfAccommodation +
                '}';
    }
}
