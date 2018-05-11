package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        URL url = new File("src/main/java/sample/sample.fxml").toURL();
        Parent root = FXMLLoader.load(url);
//        Parent root = FXMLLoader.load(getClass().getResource("../../resources/fxml/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 675));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
