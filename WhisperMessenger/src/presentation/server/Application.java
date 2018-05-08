package presentation.server;

import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.client.LoginPane;
import server.Server;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        Application.getInstance();
       launch(args);
    }

    private static Application instance;
    private static Scene mainScene;

    public Application() {
        mainScene = new Scene(new ServerPane(), 400,400);
        Server server = new Server();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static Application getInstance() {
        if(instance == null)
            instance = new Application();

        return instance;
    }

}