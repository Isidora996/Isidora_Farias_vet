module cl.duoc.isidora_farias {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens cl.duoc.isidora_farias to javafx.fxml;
    exports cl.duoc.isidora_farias;

    opens cl.duoc.isidora_farias.controller to javafx.fxml;

    opens cl.duoc.isidora_farias.model to com.google.gson, javafx.base;
}

