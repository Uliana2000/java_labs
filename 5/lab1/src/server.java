import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Arrays;
import java.util.Comparator;


public class Server  {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Server() {
        try {
            serverSocket = new ServerSocket(1001);
            System.out.println(serverSocket);
        } catch (IOException e) {
            fail(e, "Could not start server");
        }
        this.run();
    }

    public static void fail(Exception e, String str) {
        System.out.println(str + ". " + e.getMessage());
    }

    public void run() {
        try {
            while (true) {
                clientSocket = serverSocket.accept();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("Created new connection");
                String text = in.readLine();
                System.out.println("Received: " + text);
                out.println(String.join(" ", sortByLength(text)));
                out.close();
                System.out.println("Connection was closed");
            }
        } catch (IOException e) {
            fail(e, "Not listening");
        }
    }

    public String[] sortByLength(String text) {
        String[] words = text.split(" ");
        Arrays.sort(words, Comparator.comparingInt(String::length));
        return words;
    }


    public static void main(String[] args) {
        Server server = new Server();
    }
}
