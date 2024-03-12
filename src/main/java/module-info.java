module org.example.tap2024 {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires mysql.connector.j;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.tap2024 to javafx.fxml;
    exports org.example.tap2024;
    opens org.example.tap2024.modelos;
}