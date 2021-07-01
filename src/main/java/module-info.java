module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
    exports org.openjfx.controller;
    exports org.openjfx.service;
    exports org.openjfx.dao;
    exports org.openjfx.model;
    opens org.openjfx.controller to javafx.fxml;
}