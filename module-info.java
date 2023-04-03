module com.example.essalaf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;

    opens com.example.essalaf to javafx.fxml;
    exports com.example.essalaf;
}