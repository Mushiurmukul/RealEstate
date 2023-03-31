module com.example.mukul {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.mukul to javafx.fxml;
    exports com.example.mukul;
}