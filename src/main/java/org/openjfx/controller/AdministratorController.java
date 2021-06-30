package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openjfx.model.Person;
import org.openjfx.model.Tenant;
import org.openjfx.service.LoginService;
import org.openjfx.service.PersonService;
import org.openjfx.service.TenantService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable {

    private LoginService loginService;
    private TenantService tenantService;
    private PersonService personService;
    public TableColumn<Person, String> userName;
    public TableColumn<Person, Integer> phoneNumber;
    private final ObservableList<Person> dataList = FXCollections.observableArrayList();
    private final ObservableList<String> comboBoxTopics = FXCollections.observableArrayList();
    private static final File personsFile = new File("persons.txt");

    @FXML
    public TextField filterField;
    @FXML
    public TableView<Person> tableview;
    @FXML
    public ComboBox<String> comboBox;
    @FXML
    public Button addTenant;
    @FXML
    public Button deleteTenant;
    @FXML
    public TextField userNameTenant;
    @FXML
    public TextField phoneNumberTenant;

    public void initTable() {
        userName.setCellValueFactory(new PropertyValueFactory<>("user name"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    }

    public void constructSearchEngine() throws IOException {
        FilteredList<Person> filteredData = new FilteredList<>(dataList, b -> true);
        initTable();
        tableview.setItems(filteredData);
        comboBoxTopics.addAll("userName", "phoneNumber");
        comboBox.setItems(comboBoxTopics);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(person -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String comboBoxValue = comboBox.getValue();
            String lowerCaseFilter = newValue.toLowerCase();
            switch (comboBoxValue) {
                case "userName": {
                    return person.getUserName().toLowerCase().contains(lowerCaseFilter);
                }
                case "phoneNumber": {
                    return String.valueOf(person.getPhoneNumber()).toLowerCase().contains(lowerCaseFilter);
                }
                default: {
                    break;
                }
            }
            return false;
        }));
        SortedList<Person> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
    }

    public void addTenant() throws IOException {
        Tenant toBeAdded = new Tenant(userNameTenant.getText(), Integer.parseInt(phoneNumberTenant.getText()));
        personService.insert(toBeAdded);
        tenantService.insert(toBeAdded);
        personService.selectAll().forEach(System.out::println);
        FileOutputStream fileOutputStream = new FileOutputStream(personsFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Tenant tenant : tenantService.selectAll()) {
            objectOutputStream.writeObject(tenant);

        }
        fileOutputStream.close();
    }

    public void deleteTenant() throws IOException {
        Tenant toBeDeleted = new Tenant(userNameTenant.getText(), Integer.parseInt(phoneNumberTenant.getText()));
        personService.delete(toBeDeleted);
        tenantService.delete(toBeDeleted);
        personService.selectAll().forEach(System.out::println);
        FileOutputStream fileOutputStream = new FileOutputStream(personsFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Tenant tenant : tenantService.selectAll()) {
            objectOutputStream.writeObject(tenant);
        }
        fileOutputStream.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLoginService(LoginService.getInstance());
        setTenantService(TenantService.getInstance());
        setPersonService(PersonService.getInstance());
        try {
            constructSearchEngine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setTenantService(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
