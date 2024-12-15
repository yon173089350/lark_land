package landlark.winboot.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import landlark.winboot.AppFX;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class MainController {

    @FXML
    public BorderPane main;

    @FXML
    protected void onTransferFileClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(AppFX.class.getResource("fxml/manual/transfer_file.fxml"));
        main.setCenter(loader.load());
    }
}
