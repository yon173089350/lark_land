package landlark.winboot;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppFX extends Application {
    private ConfigurableApplicationContext context;

    @Override
    public void init(){
        context = SpringApplication.run(AppFX.class);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Spring Boot + JavaFX Application");
        Label label = new Label("Hello, Spring Boot with JavaFX!");
        Scene scene = new Scene(label, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Optionally, add a shutdown hook to gracefully close the Spring Boot context
        primaryStage.setOnCloseRequest(event -> Platform.runLater(() -> {
            context.close();
            Platform.exit();
        }));
    }

    @Override
    public void stop(){
        context.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
