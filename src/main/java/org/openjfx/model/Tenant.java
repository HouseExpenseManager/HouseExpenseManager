package org.openjfx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tenant extends Person implements Serializable {

    private List<String> notifications = new ArrayList<>();

    public Tenant(String userName, Integer phoneNumber) {
        super(userName, phoneNumber);
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "notifications=" + notifications +
                '}';
    }
}
