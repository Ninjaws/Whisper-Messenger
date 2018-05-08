package Presentation;

import Client.LoginPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URISyntaxException;

public class MainStage extends Application {

    public static void main(String[] args) {
        MainStage.getInstance();
       launch(args);
    }

    private static MainStage instance;
    private static Scene mainScene;
    private static Stage stage;

    public MainStage() {
        mainScene = new Scene(new LoginPane(), 400,400);
        mainScene.getStylesheets().clear();
        mainScene.getStylesheets().add(getClass().getResource("/Styles.css").toExternalForm());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(mainScene);
        primaryStage.show();
        stage = primaryStage;
    }

    public static void setNextScene(Scene scene) {
        mainScene = scene;
        stage.setScene(mainScene);
    }

    public static MainStage getInstance() {
        if(instance == null)
            instance = new MainStage();

        return instance;
    }

}
