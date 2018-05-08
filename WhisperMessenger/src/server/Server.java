package server;
import javafx.application.Platform;
import server.presentation.ServerPane;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Server instance = null;
    private ObjectOutputStream toClient = null;
    private ObjectInputStream fromClient = null;

    private Server(){
        makeServer();
    }

    private void makeServer() {
            new Thread(() -> {
                ServerSocket serverSocket = null;
                Socket socket = null;
                try {
                    //create a server socket
                    serverSocket = new ServerSocket(8000);
                    Session session = new Session();
                    new Thread(session).start();
                    while (true) {
                        socket = serverSocket.accept();
                        session.addSocket(socket);
                        Platform.runLater(() -> {
                            ServerPane.getTextArea().appendText("A user has joined");
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
    }

    public static Server getInstance(){
        if(instance == null)
            instance = new Server();
        return instance;
    }

}
