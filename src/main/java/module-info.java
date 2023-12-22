module SE2StartupProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;

    opens mainpackage;
    opens mainpackage.Logic;
    opens mainpackage.GUI;
}
