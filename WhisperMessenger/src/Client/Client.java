package client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
    }
    private static Client instance = null;

    public Client() {
        try {
            Socket socket = new Socket("localhost", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connect() throws IOException {
        if(instance == null)
            instance = new Client();
        else
            throw new IOException();
    }
}