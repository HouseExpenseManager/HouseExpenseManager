package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import org.openjfx.App;
import org.openjfx.model.Tenant;
import org.openjfx.service.LoginService;
import org.openjfx.service.TenantService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TenantController implements Initializable {

    public TextArea notificationArea;
    public LoginService loginService;
    public TenantService tenantService;

    public void showNotifications(ActionEvent actionEvent) {
        Tenant tenant = tenantService.findByPhoneNumber(loginService.getIdGrasper());
        for (String notification : tenant.getNotifications()) {
            notificationArea.appendText(notification + "\n");
        }
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        App.setRoot("login", 360, 500);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLoginService(LoginService.getInstance());
        setTenantService(TenantService.getInstance());
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setTenantService(TenantService tenantService) {
        this.tenantService = tenantService;
    }
}
