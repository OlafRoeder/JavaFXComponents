package application.controller;

import application.view.ResizeableImageView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.net.MalformedURLException;

public class MainWindowController extends AnchorPane {

    @FXML
    private Pane content;
    @FXML
    private Button loadGraphicButton;
    @FXML
    private Label graphicNameLabel;

    private ResizeableImageView resizeableImageView;
    private FileChooser fileChooser;

    @FXML
    private void initialize() {

        resizeableImageView = new ResizeableImageView();
        fileChooser = new FileChooser();

        loadGraphicButton.setOnAction(event -> loadGraphic());
        content.getChildren().add(resizeableImageView);
    }

    private void loadGraphic() {

        Scene scene = getScene();

        Window window = null;

        if (scene != null)
            window = scene.getWindow();

        File file = fileChooser.showOpenDialog(window);

        if (file == null)
            return;

        graphicNameLabel.setText(file.getName());

        try {
            resizeableImageView.setImageURL(file.toURI());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
