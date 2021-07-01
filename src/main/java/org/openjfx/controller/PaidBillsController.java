package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import org.openjfx.App;
import org.openjfx.model.Administrator;
import org.openjfx.service.AdministratorService;
import org.openjfx.util.InitApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaidBillsController implements Initializable {

    @FXML
    public TextArea notificationArea;
    private AdministratorService administratorService;


    public void logout(ActionEvent actionEvent) throws IOException {
        App.setRoot("administrator", 800, 520);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAdministratorService(AdministratorService.getInstance());
        notificationArea.setEditable(false);
        try {
            loadNotifications();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNotifications() throws IOException {
        administratorService.notifyMe();
        Administrator administrator = InitApplication.initAdminCredentials();
        for (String notification : administrator.getNotifications()) {
            notificationArea.appendText(notification + "\n");
        }
    }

    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }
}
