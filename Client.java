import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to the chat server!");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String serverResponse;
                        while ((serverResponse = in.readLine()) != null) {
                            System.out.println(serverResponse);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            Scanner scanner = new Scanner(System.in);
            String userInput;
            while (true) {
                userInput = scanner.nextLine();
                out.println(userInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}