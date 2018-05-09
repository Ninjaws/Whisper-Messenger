package client.presentation;

import client.Client;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ChatPane extends BorderPane {
    private static TextArea textArea = new TextArea();
    public ChatPane() {
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5,5,5,5));
        paneForTextField.setLeft(new Label("Enter message: "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BASELINE_RIGHT);
        paneForTextField.setCenter(tf);

        this.setCenter(new ScrollPane(textArea));
        this.setTop(paneForTextField);


        tf.setOnAction(e -> {
            try {
                Client.getToServer().writeUTF(tf.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    public static TextArea getTextArea() {
        return textArea;
    }
}
