package javafx.chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by kyojin on 06.07.17.
 */
public class ChatAPI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chat");
        Parent root = FXMLLoader.load(getClass().getResource("/javafx/chat/main.fxml"));
        Scene main = new Scene(root);
        primaryStage.setScene(main);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
