package server;

import Entities.User;
import server.presentation.ServerPane;

import java.net.Socket;
import java.util.ArrayList;

public class Session implements Runnable {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Socket> sockets = new ArrayList<>();

    public Session(){

    }

    public void addSocket(Socket socket){
        sockets.add(socket);
    }

    @Override
    public void run() {
        while(true){
            for(Socket socket : sockets){
                System.out.println(socket.getInetAddress());
            }
        }
    }
}
