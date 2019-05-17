module codes.fer {
    requires javafx.controls;
    requires javafx.fxml;

    opens codes.fer to javafx.fxml;
    exports codes.fer;
}