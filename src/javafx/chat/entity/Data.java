package javafx.chat.entity;

/**
 * Created by kyojin on 08.07.17.
 */
public class Data {

    private String message;

    public Data(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Data: " + message + "\n";
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
