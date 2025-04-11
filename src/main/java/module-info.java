module com.example.orm {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.jfoenix;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens com.example.orm to javafx.fxml;
    opens com.example.orm.config to jakarta.persistence;
    opens com.example.orm.entity to org.hibernate.orm.core;
    opens com.example.orm.controller to javafx.fxml;
    opens com.example.orm.dto to javafx.base;

    exports com.example.orm;
}