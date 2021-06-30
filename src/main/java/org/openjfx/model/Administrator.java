package org.openjfx.model;

import java.io.Serializable;

public class Administrator extends Person implements Serializable {

    public static Administrator administrator = null;

    private Administrator(String userName, Integer phoneNumber) {
        super(userName, phoneNumber);
    }

    public static Administrator getInstance(String userName, Integer phoneNumber) {
        if (administrator == null) {
            administrator = new Administrator(userName, phoneNumber);
        }
        return administrator;
    }
}
