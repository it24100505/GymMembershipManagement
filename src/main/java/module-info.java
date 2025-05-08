module com.gym.membershipmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.servlet;
    requires java.logging;

    opens com.gym.model to javafx.base;
    exports com.gym.model;

    opens com.gym.servlet;
    exports com.gym.servlet;
}
