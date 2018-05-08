package server;

import Entities.User;

import java.net.Socket;
import java.util.ArrayList;

public class Session implements Runnable {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Socket> sockets = new ArrayList<>();
    
    @Override
    public void run() {

    }
}
