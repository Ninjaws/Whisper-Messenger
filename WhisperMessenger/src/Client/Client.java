package client;

import Entities.Messages.Message;
import Entities.User;
import client.presentation.ChatPane;
import javafx.application.Platform;

import java.io.*;
import java.net.Socket;

public class Client {
    private static ObjectOutputStream toServer = null;
    private static ObjectInputStream fromServer = null;
    private static User user;

    public Client(User user) throws Exception {
        this.user = user;
        Socket socket = new Socket("localhost", 8000);
        toServer = new ObjectOutputStream(socket.getOutputStream());
        fromServer = new ObjectInputStream(socket.getInputStream());
        ChatPane.getTextArea().appendText("You have been connected.");
        new Thread(() -> {
            while (true){
                try {
                    Message message = (Message)fromServer.readObject();
                    ChatPane.getTextArea().appendText("\n" + message.getUser().getName() + "says: " +  message.getText());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            }).start();
    }

    public static ObjectOutputStream getToServer() {
        return toServer;
    }

    public static ObjectInputStream getFromServer() {
        return fromServer;
    }

    public static User getUser() {
        return user;
    }
}