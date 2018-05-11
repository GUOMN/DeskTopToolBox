package com.guomn.desktopToolbox.sample;

import com.guomn.desktopToolbox.utils.HttpClint;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Controller {


    public TextField username;
    public TextField pw;
    public Button loginButton;

    /**
     * 跳转登陆的按钮
     * @param actionEvent
     * @throws IOException
     */
    public void link2loginbuttonSubmit(ActionEvent actionEvent) throws IOException {

        Stage login = new Stage();

        URL path = getClass().getResource("/fxml/LogIn.fxml");
        Parent root = FXMLLoader.load(path);
        login.setTitle("Login");
        login.setScene(new Scene(root, 600, 475));
        login.show();
    }

    /**
     * 登陆按钮
     * @param actionEvent
     */
    public void loginSubmit(ActionEvent actionEvent) {

        System.out.println(username.getText());
        System.out.println(pw.getText());
        try {
            System.out.println(HttpClint.getGETString("http://vps1.guomn.cn/healthchk"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = (Stage)loginButton.getScene().getWindow();
        stage.close();
    }


}
