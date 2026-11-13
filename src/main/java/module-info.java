module com.example.utsstrukdat {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.csv;
    requires java.sql;

    exports com.example.utsstrukdat.view;
    opens com.example.utsstrukdat.view to javafx.fxml;
    opens com.example.utsstrukdat.app to javafx.fxml;
    exports com.example.utsstrukdat.app;
}