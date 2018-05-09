package server;

import Entities.User;
import server.presentation.ServerPane;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Session implements Runnable {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Socket> sockets = new ArrayList<>();
    private ArrayList<DataInputStream> fromClients = new ArrayList<>();
    private ArrayList<DataOutputStream> toClients = new ArrayList<>();
    public Session(){

    }

    public void addSocket(Socket socket){
        try {
            fromClients.add(new DataInputStream(socket.getInputStream()));
            toClients.add(new DataOutputStream(socket.getOutputStream()));
            sockets.add(socket);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't join session");
        }
    }

    @Override
    public void run() {
        while(true){
            System.out.println(sockets.size());
            for(DataInputStream fromClient : fromClients){
                try {
                    String data = fromClient.readUTF();
                    ServerPane.getTextArea().appendText(data + "\n");
                    for(DataOutputStream toClient : toClients){
                        toClient.writeUTF(data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
