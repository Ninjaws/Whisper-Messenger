package server.data;
import Entities.Messages.Message;
import Entities.User;
import server.presentation.ServerPane;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Session implements Runnable{
    private Socket user;
    private ObjectInputStream fromClient = null;
    private ObjectOutputStream toClient = null;

    public Session(Socket user) {
        this.user = user;
        try {
            this.fromClient = new ObjectInputStream(user.getInputStream());
            this.toClient = new ObjectOutputStream(user.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToAll(Object object){
        for(Session session : Server.getSessions()){
            try {
                session.toClient.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Message message = (Message)fromClient.readObject();
                ServerPane.getTextArea().appendText(message.getUser().getName() + "says something...");
                writeToAll(message);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}