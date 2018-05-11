package client.presentation;

import Entities.Messages.Message;
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
        this.getStyleClass().add("ChatPane");
        this.setMinSize(Double.MAX_VALUE,Double.MAX_VALUE);
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5,5,5,5));
        paneForTextField.setLeft(new Label("Enter message: "));
        TextField tf = new TextField();
        tf.setId("chatField");
        tf.setAlignment(Pos.BASELINE_RIGHT);
        paneForTextField.setCenter(tf);
        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        this.setCenter(scrollPane);
        this.setBottom(paneForTextField);


        tf.setOnAction(e -> {
            try {
                Message message = new Message(Client.getUser(),tf.getText());
                tf.clear();
                Client.getToServer().writeObject(message);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    public static TextArea getTextArea() {
        return textArea;
    }
}
