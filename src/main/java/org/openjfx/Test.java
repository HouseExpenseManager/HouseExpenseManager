package org.openjfx;

import org.openjfx.model.Apartment;
import org.openjfx.model.HouseOwner;
import org.openjfx.model.Tenant;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Apartment apartment = new Apartment(2, "Cluj-Napoca", "Cluj");
        HouseOwner houseOwner = new HouseOwner(apartment, "Luca", 0744324221);
        Tenant tenant1 = new Tenant("Oana", 766832445, Date.from(Instant.now()));
        Tenant tenant2 = new Tenant("Daria", 766832225, Date.from(Instant.now()));
        houseOwner.addTenant(tenant1);
        houseOwner.addTenant(tenant2);

        houseOwner.displayTenants();

    }
}
