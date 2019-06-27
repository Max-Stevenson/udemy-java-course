package JavaFXChallengeTwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXChallengeTwoApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/JavaFXChallengeTwo/fxml/mainWindow.fxml"));
        primaryStage.setTitle("My Contacts");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
