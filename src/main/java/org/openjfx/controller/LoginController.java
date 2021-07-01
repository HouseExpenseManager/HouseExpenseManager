package org.openjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.openjfx.App;
import org.openjfx.model.Person;
import org.openjfx.service.LoginService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private LoginService loginService;

    @FXML
    public TextField userTextField;
    @FXML
    public TextField phoneNumberTextField;
    @FXML
    public Label errorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorLabel.setVisible(false);
        setLoginService(LoginService.getInstance());

    }

    public int login() throws IOException {

        int idGrasper = 0;
        if (checkIfFieldIsEmpty()) {
            errorLabel.setText("          Some fields are let empty");
            errorLabel.setVisible(true);
        } else {
            Person formUser = new Person(userTextField.getText(), Integer.parseInt(phoneNumberTextField.getText()));
            String option = loginService.logIn(formUser);
            if (option != null) {
                idGrasper = loginService.getIdGrasper();
                if (option.equals("TENANT")) {
                    App.setRoot("tenant", 700, 500);
                } else
                    App.setRoot("administrator", 800, 520);
            } else {
                errorLabel.setText("            User does not exist");
                errorLabel.setVisible(true);
            }
        }
        return idGrasper;
    }

    public boolean checkIfFieldIsEmpty() {
        return userTextField.getText().isBlank() || phoneNumberTextField.getText().isBlank();
    }

    public void register() throws IOException {
        App.setRoot("register", 360, 500);
    }
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
