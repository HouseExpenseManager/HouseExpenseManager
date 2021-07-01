package org.openjfx.model;

import java.util.Date;

public class Bill {
    private int ID;
    private BillTypes name;
    private Date dateOfRelease;
    private String type;
    private boolean status;
    private Date dateOfPayment;
    private int totalAmount;

    public Bill(int ID, String type, Date dateOfRelease, boolean status, int totalAmount) {
        this.ID = ID;
        this.type = type;
        this.dateOfRelease = dateOfRelease;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public Bill(int ID, BillTypes name, Date dateOfRelease, String type, boolean status, Date dateOfPayment, int totalAmount) {
        this.ID = ID;
        this.name = name;
        this.dateOfRelease = dateOfRelease;
        this.type = type;
        this.status = status;
        this.dateOfPayment = dateOfPayment;
        this.totalAmount = totalAmount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public BillTypes getName() {
        return name;
    }

    public void setName(BillTypes name) {
        this.name = name;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "ID=" + ID +
                ", name=" + name +
                ", dateOfRelease=" + dateOfRelease +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", dateOfPayment=" + dateOfPayment +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

