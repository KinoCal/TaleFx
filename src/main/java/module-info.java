module com.example.talefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.talefx to javafx.fxml;
    exports com.example.talefx;

}