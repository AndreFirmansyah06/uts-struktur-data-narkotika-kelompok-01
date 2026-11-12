module com.example.utsstrukdat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.utsstrukdat to javafx.fxml;
    exports com.example.utsstrukdat;
}