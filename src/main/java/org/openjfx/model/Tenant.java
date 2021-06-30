package org.openjfx.model;

import java.io.Serializable;

public class Tenant extends Person implements Serializable {
    public Tenant(String userName, Integer phoneNumber) {
        super(userName, phoneNumber);
    }
}
