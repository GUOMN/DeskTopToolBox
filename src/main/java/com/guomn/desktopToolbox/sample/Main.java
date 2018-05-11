package com.guomn.desktopToolbox.sample;

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

//        String path = Main.class.getResource("/fxml/index.fxml").getPath();
//        String path =Thread.currentThread().getContextClassLoader().getResource("").getPath() + "/fxml/index.fxml";
        URL path = getClass().getResource("/fxml/index.fxml");
        //最大的坑！！！！
//        URL url = new File(path).toURL();

        Parent root = FXMLLoader.load(path);
        primaryStage.setTitle("Tool Box");
        primaryStage.setScene(new Scene(root, 1200, 875));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
