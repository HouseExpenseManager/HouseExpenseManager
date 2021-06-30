package org.openjfx.service;

import org.openjfx.dao.TenantDao;
import org.openjfx.model.Tenant;

import java.util.List;

public class TenantService {

    private static TenantService tenantService = null;
    public static TenantDao tenantDataAccessService = new TenantDao();

    public TenantService(TenantDao tenantDataAccessService) {
        TenantService.tenantDataAccessService = tenantDataAccessService;
    }

    public static TenantService getInstance() {
        if (tenantService == null) {
            tenantService = new TenantService(tenantDataAccessService);
        }
        return tenantService;
    }

    public void insert(Tenant model) {
        tenantDataAccessService.insert(model);
    }

    public List<Tenant> selectAll() {
        return tenantDataAccessService.selectAll();
    }

    public Tenant delete(Tenant model) {
        return tenantDataAccessService.delete(model);
    }

    public Tenant findByPhoneNumber(Integer phoneNumber) {
        return tenantDataAccessService.findByPhoneNumber(phoneNumber);
    }
}
