module com.example.ebms {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires mysql.connector.java;

    opens com.example.ebms to javafx.fxml;
    exports com.example.ebms;
}

