package org.openjfx.model;

import java.io.Serializable;

public class Person implements Serializable {

    private String userName;
    private Integer phoneNumber;

    public Person(String userName, Integer phoneNumber) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
