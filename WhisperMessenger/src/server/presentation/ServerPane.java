package server.presentation;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import server.Server;


public class ServerPane extends HBox{
    private static TextArea textArea = new TextArea();
    public ServerPane() {
        textArea.setEditable(false);
        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        getChildren().addAll(scrollPane);
        start();
    }

    public void start() {
        Server server = new Server();
    }

    public static TextArea getTextArea() {
        return textArea;
    }
}
