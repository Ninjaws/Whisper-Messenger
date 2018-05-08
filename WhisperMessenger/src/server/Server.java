package server;
import javafx.application.Platform;
import presentation.server.ServerPane;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void makeServer() {
        new Thread(() -> {
            ServerSocket serverSocket = null;
            Socket socket = null;
            try {
                //create a server socket
                serverSocket = new ServerSocket(8000);

                while (true) {
                    socket = serverSocket.accept();
                    Platform.runLater(() -> {
                        ServerPane.getTextArea().appendText("A user has joined");
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
