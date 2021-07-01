package org.openjfx.dao;

import org.openjfx.model.Tenant;

import java.util.ArrayList;
import java.util.List;

public class TenantDao implements DAO<Tenant> {

    private final List<Tenant> tenants = new ArrayList<>();


    @Override
    public Tenant findByPhoneNumber(Integer phoneNumber) {
        for (Tenant tenant : tenants) {
            if (tenant.getPhoneNumber().equals(phoneNumber)) {
                return tenant;
            }
        }
        return null;
    }

    @Override
    public List<Tenant> selectAll() {
        return tenants;
    }

    @Override
    public Tenant delete(Integer phoneNumber) {
        Tenant tenant = findByPhoneNumber(phoneNumber);
        if (tenant != null) {
            tenants.removeIf(user1 -> user1.equals(tenant));
            return tenant;
        } else return null;
    }

    @Override
    public Tenant insert(Tenant model) {
        tenants.add(model);
        return model;
    }

    @Override
    public Tenant delete(Tenant model) {
        Tenant tenant = findByPhoneNumber(model.getPhoneNumber());
        if (tenant != null) {
            tenants.remove(tenant);
        }
        return tenant;
    }
}
