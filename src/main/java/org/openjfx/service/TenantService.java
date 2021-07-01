package org.openjfx.service;

import org.openjfx.dao.TenantDao;
import org.openjfx.model.Bill;
import org.openjfx.model.Tenant;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    public void delete(Tenant model) {
        tenantDataAccessService.delete(model);
    }

    public Tenant findByPhoneNumber(Integer phoneNumber) {
        return tenantDataAccessService.findByPhoneNumber(phoneNumber);
    }

    public void notifyMe(String sum, Tenant tenant, String billType) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dateAndTime = LocalDateTime.now();
        String stringDateTime = myFormatObj.format(dateAndTime);
        Bill bill = new Bill(tenant.getBills().size() + 1, billType, Date.from(Instant.now()), false, Integer.parseInt(sum));
        tenant.getBills().add(bill);
    }
}
