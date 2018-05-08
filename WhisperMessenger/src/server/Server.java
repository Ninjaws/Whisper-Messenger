package server;

import javafx.application.Platform;
import presentation.server.ServerPane;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
    public Server() {
        new Thread(() ->{
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                while(true) {
                    Socket user = serverSocket.accept();
                        Platform.runLater(()-> {
                            ServerPane.getTextArea().appendText("New User has joined");
                        });
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Server couldn't be made");
                System.exit(-1);
            }
        }).start();
    }

}
