package client;

import client.presentation.ChatPane;
import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
    }
    private static DataOutputStream toServer = null;
    private static DataInputStream fromServer = null;

    public Client() {
        try {
            Socket socket = new Socket("localhost", 8000);
            toServer = new DataOutputStream(socket.getOutputStream());
            fromServer = new DataInputStream(socket.getInputStream());
            new Thread(() -> {
                while (true){
                    try {
                        System.out.println(true);
                        ChatPane.getTextArea().appendText(fromServer.readUTF());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataOutputStream getToServer() {
        return toServer;
    }

    public static DataInputStream getFromServer() {
        return fromServer;
    }
}