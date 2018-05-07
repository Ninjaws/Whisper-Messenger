import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainStage extends Application {

    public static void main(String[] args) {
        MainStage.getInstance();
       launch(args);
    }

    private static MainStage instance;
    private static Scene mainScene;

    public MainStage() {
        mainScene = new Scene(new LoginPane(), 400,400);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void setNextScene(Scene scene) {
        mainScene = scene;
    }

    public static MainStage getInstance() {
        if(instance == null)
            instance = new MainStage();

        return instance;
    }

    public static void testSingleton() {
        System.out.println(true);
    }
}
