package client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private static Client instance = null;

    private Client() throws IOException {
        Socket socket = new Socket("localhost", 8000);
    }

    public static void connect() throws IOException {
        if(instance == null)
            instance = new Client();
        else
            throw new IOException();
    }
}