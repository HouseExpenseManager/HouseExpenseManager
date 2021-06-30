package org.openjfx.model;

public class HouseOwner extends Person {
    private Apartment apartment;

    public HouseOwner(Apartment apartment, String houseOwnerName, int houseOwnerPhoneNumber) {
        super(houseOwnerName, houseOwnerPhoneNumber);
        this.apartment = apartment;
    }

    void addBill(Bill bill) {
        apartment.getBills().add(bill);
        System.out.println("Factura a fost adaugata cu succes");
    }


    void displayUnpaidBills() {
        for (Bill bill : apartment.getBills()) {
            if (bill.isStatus() == false) {
                System.out.println(bill.toString());
            }

        }
    }

    public void addTenant(Tenant tenant) {
        apartment.getTenants().add(tenant);
        System.out.println("Chiriasul " + tenant.getName() + " a fost adaugat in apartament");

    }

    void removeTenant(int phoneNumber) {
        for (Tenant tenant : apartment.getTenants()) {
            if (tenant.getPhoneNumber() == phoneNumber) {
                System.out.println("Chiriasul " + tenant.getName() + " a fost adaugat in apartament");
                apartment.getTenants().remove(tenant);
            }


        }

    }

    public void displayTenants() {
        for (Tenant tenant : apartment.getTenants()) {
            System.out.println(tenant.toString());
        }
    }
}
