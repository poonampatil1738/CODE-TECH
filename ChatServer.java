import java.io.*;
import java.net.*;
import java.util.Vector;

/*
 * CODTECH Internship Task - 3
 * Multithreaded Chat Server
 */

public class ChatServer {

    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started... Waiting for clients...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            ClientHandler client = new ClientHandler(socket);
            clients.add(client);

            Thread thread = new Thread(client);
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {

    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Message: " + message);

                // send message to all clients
                for (ClientHandler client : ChatServer.clients) {
                    client.out.println(message);
                }
            }

        } catch (Exception e) {
            System.out.println("Client disconnected");
        }
    }
                     }
