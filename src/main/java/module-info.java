module com.example.selfproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.selfproject to javafx.fxml;
    exports com.example.selfproject;
}