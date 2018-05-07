import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Client extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //makes gridPane with horizontal gap and vertical gap with padding.
        Scene loginScene = new Scene(new LoginPane(),400,400);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Whisper");
        primaryStage.show();
    }

}
