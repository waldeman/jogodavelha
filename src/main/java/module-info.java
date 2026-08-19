module org.example.jogodavelha {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.jogodavelha to javafx.fxml;
    exports org.example.jogodavelha;
}