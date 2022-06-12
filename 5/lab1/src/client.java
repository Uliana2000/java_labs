import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String host, int port) throws IOException {
        clientSocket = new Socket(host, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sortWords(String text) throws IOException {
        out.println(text);
        return in.readLine();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Scanner in = new Scanner(System.in);
        while (true){
            client.startConnection("localhost", 1001);
            System.out.print("Input text: ");
            String text = in.nextLine();
            if (".".equals(text)) {
                System.out.println("Goodbye!");
                client.stopConnection();
                break;
            }
            String result = client.sortWords(text);
            System.out.println("Sorted: " + result);
            client.stopConnection();
        }
    }
}
