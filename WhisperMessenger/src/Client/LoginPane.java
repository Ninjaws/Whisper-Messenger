package Client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import Presentation.MainStage;

public class LoginPane extends GridPane {
    public LoginPane() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));

        Text title = new Text("Whisper");
        add(title, 0, 0);
        Label userName = new Label("User Name:");
        add(userName, 0, 1);

        TextField userNameField = new TextField();
        add(userNameField, 1, 1);

        Label passwordLabel = new Label("Password:");
        add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        add(passwordField, 1, 2);

        Button logInButton = new Button("Log In");
        add(logInButton,0,3);
        logInButton.setOnAction(event -> MainStage.setNextScene(new Scene(new ChatPane(), 400,400)));

        Button registerButton = new Button("Register");
        add(registerButton,1,3);
        registerButton.setOnAction(event -> MainStage.setNextScene(new Scene(new ChatPane(), 400,400)));
        this.setStyle("-fx-background: Black;");
    }
}
