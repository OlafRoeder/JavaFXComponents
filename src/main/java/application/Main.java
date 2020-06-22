package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();

        URL resource = Main.class.getResource("view/MainWindowView.fxml");

        loader.setLocation(resource);

        AnchorPane mainWindow = loader.load();

        primaryStage.setScene(new Scene(mainWindow));
        primaryStage.show();
    }
}