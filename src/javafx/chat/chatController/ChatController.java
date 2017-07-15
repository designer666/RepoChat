package javafx.chat.chatController;

import javafx.chat.entity.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Created by kyojin on 06.07.17.
 */
public class ChatController {

    private ObservableList<Data> data;

    @FXML private TextArea txtIn;
    @FXML private ListView<Data> txtOut;
    private MouseEvent mouseEvent;

    @FXML
    private void initialize() {
        data = FXCollections.observableArrayList();
        txtOut.setItems(data);
        txtOut.addEventHandler(EventType.ROOT, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                Data data = txtOut.getSelectionModel().getSelectedItem();
                txtIn.setText(data.getMessage());
            }
        });
    }

    @FXML
    private void onClickNewDataButton() {
        data.add(new Data(txtIn.getText()));
        txtIn.clear();
    }

    @FXML
    private void onClickExitButton() {
        System.exit(0);
    }

    public void setOnMouseClickedLogin(MouseEvent mouseEvent) {

    }

    Button login = new Button("Log in");
    /*login.setOnMouseClickedLogin(newEventHandler() {

    });*/


}
