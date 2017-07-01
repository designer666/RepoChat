package chat.main;

import chat.client.Client;
import chat.server.Server;

import java.util.Scanner;

/**
 * Created by kyojin on 30.06.17.
 */
public class Main {

    public static void main(String[] args) {

        Scanner enter = new Scanner(System.in);

        System.out.println("Запустить север или клиент? (s(server)/c(client))");

        while (true) {
            char answer = Character.toLowerCase(enter.nextLine().charAt(0));
            if (answer == 's') {
                new Server();
                break;
            } else if (answer == 'c') {
                new Client();
                break;
            } else {
                System.out.println("Некорректный ввод, повторите");
            }
        }
    }
}
