package server;
import server.presentation.ServerPane;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static Server instance = null;

    private ArrayList<Session> sessions = new ArrayList<>();
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

    private class Session implements Runnable{
        private Socket user;
        private DataInputStream fromClient = null;
        private DataOutputStream toClient = null;

        public Session(Socket user) {
            this.user = user;
            try {
                this.fromClient = new DataInputStream(user.getInputStream());
                this.toClient = new DataOutputStream(user.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void writeToAll(String data){
            for(Session session : sessions){
                try {
                    session.toClient.writeUTF(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            while(true){
                try {
                    String data = fromClient.readUTF();
                    ServerPane.getTextArea().appendText(data);
                    writeToAll(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


