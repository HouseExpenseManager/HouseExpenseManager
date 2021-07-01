package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openjfx.App;
import org.openjfx.model.Bill;
import org.openjfx.model.Tenant;
import org.openjfx.service.AdministratorService;
import org.openjfx.service.LoginService;
import org.openjfx.service.TenantService;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class TenantController implements Initializable {

    private LoginService loginService;
    private TenantService tenantService;
    private AdministratorService administratorService;

    @FXML
    public TextArea notificationArea;
    @FXML
    public TableView<Bill> tableview;
    private final ObservableList<Bill> dataList = FXCollections.observableArrayList();
    @FXML
    public TableColumn<Bill, Integer> id;
    @FXML
    public TableColumn<Bill, String> type;
    @FXML
    public TableColumn<Bill, Date> dateOfRelease;
    @FXML
    public TableColumn<Bill, Boolean> status;
    @FXML
    public TableColumn<Bill, Date> dateOfPayment;
    @FXML
    public TableColumn<Bill, Integer> totalAmount;

    public void showNotifications(ActionEvent actionEvent) {
        FilteredList<Bill> filteredData = new FilteredList<>(dataList, b -> true);
        initTable();
        tableview.setItems(filteredData);
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        App.setRoot("login", 360, 500);
    }

    void initTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateOfRelease.setCellValueFactory(new PropertyValueFactory<>("dateOfRelease"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateOfPayment.setCellValueFactory(new PropertyValueFactory<>("dateOfPayment"));
        totalAmount.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        Tenant tenant = tenantService.findByPhoneNumber(loginService.getIdGrasper());
        dataList.addAll(tenant.getBills());
    }

    public void payBills() throws IOException {
        Bill payedBill = tableview.getSelectionModel().getSelectedItem();
        Tenant tenant = tenantService.findByPhoneNumber(loginService.getIdGrasper());
        String notification = tenant.getUserName() + "  " + payedBill;
        administratorService.setCurrentNotification(notification);
        administratorService.notifyMe();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLoginService(LoginService.getInstance());
        setTenantService(TenantService.getInstance());
        setAdministratorService(AdministratorService.getInstance());
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setTenantService(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }
}
