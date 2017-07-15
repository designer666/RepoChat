package javafx.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kyojin on 30.06.17.
 */
public class Client {

    private BufferedReader in;
    private PrintWriter out;
    private Socket  socket;

    public Client() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите IP для подключения к серверу");

        String ip = scan.nextLine();

        try {
            socket = new Socket(ip, 8080);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Введите свой ник:");
            out.println(scan.nextLine());

            Resender resend = new Resender();
            resend.start();

            String str = "";
            while (!str.equals("exit")) {
                str = scan.nextLine();
                out.println(str);
            }
            resend.setStop();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Потоки не закрыты!");
        }
    }

    public class Resender extends Thread {
        private boolean stoped;

        public void setStop() {
            stoped = true;
        }

        @Override
        public void run() {
            while (!stoped) {
                try {
                    String str = in.readLine();
                    System.out.println(str);
                } catch (IOException e) {
                    System.err.println("Ошибка при получении сообщения!");
                    e.printStackTrace();
                }
            }
        }
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
