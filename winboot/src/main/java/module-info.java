module winboot {
    requires javafx.controls;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires static lombok;
    requires spring.beans;
    requires java.desktop;
    requires spring.core;

    opens landlark.winboot to javafx.fxml;
    opens landlark.winboot.controller to javafx.fxml;
    opens landlark.winboot.controller.manaul to javafx.fxml;
    opens landlark.winboot.ui.model to javafx.base;

    exports landlark.winboot;
}