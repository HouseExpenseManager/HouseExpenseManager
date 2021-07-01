package org.openjfx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends Person implements Serializable {

    public static Administrator administrator = null;
    private List<String> notifications = new ArrayList<>();

    private Administrator(String userName, Integer phoneNumber) {
        super(userName, phoneNumber);
    }

    public static Administrator getInstance(String userName, Integer phoneNumber) {
        if (administrator == null) {
            administrator = new Administrator(userName, phoneNumber);
        }
        return administrator;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "notifications=" + notifications +
                '}';
    }
}

