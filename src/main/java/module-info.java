module org.example.tap2024 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tap2024 to javafx.fxml;
    exports org.example.tap2024;
}