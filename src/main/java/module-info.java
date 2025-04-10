module com.example.orm {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.jfoenix;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens com.example.orm to javafx.fxml;
    opens com.example.orm.controllers to javafx.fxml;
    opens com.example.orm.dto to javafx.base;

    exports com.example.orm;
}