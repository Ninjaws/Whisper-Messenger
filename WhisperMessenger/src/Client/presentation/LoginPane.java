package client.presentation;

import Entities.User;
import client.Client;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import sun.applet.AppletListener;

public class LoginPane extends GridPane {
    private Button logInButton, registerButton;
    private Text errorMessage;
    public LoginPane() {
        this.getStyleClass().add("LoginPane");
        //sets position of the pane.
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        this.setMinSize(Double.MAX_VALUE,Double.MAX_VALUE);

        //adds the title of the application
        Text title = new Text("Whisper");
        title.setId("title");
        add(title, 0, 0);

        //adds user name label
        Label userName = new Label("User Name:");
        add(userName, 0, 1);

        //adds username field
        TextField userNameField = new TextField();
        add(userNameField, 1, 1);

        Label passwordLabel = new Label("Password:");
        add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        add(passwordField, 1, 2);

        errorMessage = new Text("Could not connect to server");
        errorMessage.setId("ErrorMessage");
        errorMessage.setVisible(false);
        add(errorMessage,0,4);

        //adds login button todo: add enter listener.
        logInButton = new Button("Log In");
        add(logInButton,0,3);
        logInButton.setOnAction(event -> {
            try{
                User user = new User(userNameField.getText(), passwordField.getText());
                Client client = new Client(user);

                Application.setNextScene(new Scene(new ChatPane(), 400,400));
                Application.setStyle("ChatStyle.css");
            }
            catch (Exception e){
                errorMessage.setVisible(true);
                e.printStackTrace();
            }
        });

        //adds registerbutton
        registerButton = new Button("Register");
        add(registerButton,1,3);
        registerButton.setOnAction(event -> Application.setNextScene(new Scene(new ChatPane(), 400,400)));
    }
}
