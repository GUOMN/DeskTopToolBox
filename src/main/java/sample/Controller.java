package sample;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {


    public TextField username;
    public TextField pw;

    public void LogInButtonSubmit(MouseEvent mouseEvent) {
        System.out.println(username.getText());
        System.out.println(pw.getText());

    }
}
