package server.data;
import server.presentation.ServerPane;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class Server {
    private static Server instance = null;

    private static ArrayList<Session> sessions = new ArrayList<>();
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
                    ServerPane.getTextArea().appendText("A server has been started on: " + new Date());
                    while (true) {
                        socket = serverSocket.accept();
                        Session session = new Session(socket);
                        sessions.add(session);
                        new Thread(session).start();
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

    public static ArrayList<Session> getSessions() {
        return sessions;
    }
}


