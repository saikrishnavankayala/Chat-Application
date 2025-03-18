import java.io.*;
import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList; 
import java.util.Scanner;

public class Server { 
    private static final int PORT = 12345; 
    private static CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>(); 
    public static void main(String[] args) { 
        try { 
            ServerSocket serverSocket = new ServerSocket(PORT); 
            System.out.println("Server is running and waiting for connections..");  
            while (true) { 
                Socket clientSocket = serverSocket.accept(); 
                System.out.println("New client connected: " + clientSocket);  
                ClientHandler clientHandler = new ClientHandler(clientSocket); 
                clients.add(clientHandler); 
                new Thread(clientHandler).start(); 
            } 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
    public static void broadcast(String message, ClientHandler sender) { 
        for (ClientHandler client : clients) { 
            if (client != sender) { 
                client.sendMessage(message); 
            } 
        } 
    } 
    private static class ClientHandler implements Runnable { 
        private Socket clientSocket; 
        private PrintWriter out; 
        private BufferedReader in; 
        private String Username; 
        public ClientHandler(Socket socket) { 
            this.clientSocket = socket; 
          try { 
                // Create input and output streams for communication 
                out = new PrintWriter(clientSocket.getOutputStream(), true); 
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
        @Override
        public void run() { 
            try {  
                Username = getUsername();
                System.out.println("User " + Username + " connected.");
                out.println("Welcome to the chat, " + Username + "!");
                out.println("Type Your Message"); 
                String inputLine; 
                 while ((inputLine = in.readLine()) != null)
 { 
                    System.out.println("[" + Username + "]: " + inputLine); 
                    broadcast("[" + Username + "]: " + inputLine, this);                 } 

                                clients.remove(this); 

                                in.close(); 
                out.close(); 
                clientSocket.close(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 

                private String getUsername() throws IOException { 
            out.println("Enter your username:"); 
            return in.readLine(); 
        } 

        public void sendMessage(String message) { 
            out.println(message); 
            out.println("Type Your Message"); 
        } 
    }  
}