package presentation.client;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        Application.getInstance();
       launch(args);
    }

    private static Application instance;
    private static Scene mainScene;
    private static Stage stage;

    public Application() {
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

    public static Application getInstance() {
        if(instance == null)
            instance = new Application();

        return instance;
    }

}
