package landlark.winboot.controller.manaul;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import landlark.winboot.service.manaul.TransferFileService;
import landlark.winboot.ui.model.ManualUploadModel;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Log4j2
public class TransferFileController implements Initializable {
    @FXML
    private TableView<ManualUploadModel> manualTableView;

    @FXML
    private TableColumn<ManualUploadModel, String> manualTableColumnMessage;

    private final TransferFileService transfterFileService = new TransferFileService();

    @FXML
    protected void onUploadFileClick() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilterTXT
                = new FileChooser.ExtensionFilter("Text file (*.TXT,*.txt)", "*.txt", "*.TXT");
        fileChooser.getExtensionFilters()
                .addAll(extFilterTXT);
        File file = fileChooser.showOpenDialog(null);

        try {
            List<String> newList = transfterFileService.upload(file);
            if (!newList.isEmpty()) {
                manualTableView.getItems().removeAll();

                List<ManualUploadModel> tmpList = new ArrayList<>();
                newList.forEach(msg ->
                        tmpList.add(ManualUploadModel.builder().message(msg).build())
                );
                ObservableList<ManualUploadModel> list = FXCollections.observableList(tmpList);
                manualTableView.setItems(list);
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            log.error(e.getMessage());
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manualTableColumnMessage.setCellValueFactory(new PropertyValueFactory<>("Message"));

    }
}
