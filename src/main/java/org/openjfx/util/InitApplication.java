package org.openjfx.util;

import org.openjfx.model.Administrator;
import org.openjfx.model.Tenant;
import org.openjfx.service.PersonService;
import org.openjfx.service.TenantService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InitApplication {

    private static final File personsFile = new File("persons.txt");
    private static final PersonService personService = PersonService.getInstance();

    public static Administrator initAdminCredentials() throws IOException {
        File file = new File("adminCredentials");
        String name = null;
        int phoneNumber = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            name = br.readLine();
            phoneNumber = Integer.parseInt(br.readLine());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        personService.insert(Administrator.getInstance(name, phoneNumber));
        FileOutputStream fileOutputStream = new FileOutputStream(personsFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(personService.selectAll().get(0));
        fileOutputStream.close();
        return Administrator.getInstance(name, phoneNumber);
    }

    public static void deserializeInitialTenants(String fileName) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Tenant> tenants = new ArrayList<>();
        TenantService tenantService = TenantService.getInstance();
        while (true) {
            try {
                tenants.add((Tenant) objectInputStream.readObject());
            } catch (Exception e) {
                break;
            }
        }
        objectInputStream.close();
        fileInputStream.close();
        for (Tenant tenant : tenants) {
            tenantService.insert(tenant);
        }
        tenants.forEach(System.out::println);
    }
}

