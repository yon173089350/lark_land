package landlark.winboot;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@SpringBootApplication
@Configuration(proxyBeanMethods = false)
public class AppFX extends Application {
    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = SpringApplication.run(AppFX.class);
    }

    @Override
    public void start(Stage mainStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppFX.class.getResource("fxml/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), mainStage.getMaxHeight(), mainStage.getMaxWidth());
        mainStage.setTitle("");
        mainStage.setScene(scene);
        mainStage.show();

        mainStage.setOnCloseRequest(event -> Platform.runLater(() -> {
            context.close();
            Platform.exit();
        }));
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
