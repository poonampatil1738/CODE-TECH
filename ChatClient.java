import java.io.*;
import java.net.*;
import java.util.Scanner;

/*
 * CODTECH Internship Task - 3
 * Chat Client
 */

public class ChatClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        Scanner sc = new Scanner(System.in);

        // Thread to receive messages
        Thread receiveThread = new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (Exception e) {
            }
        });

        receiveThread.start();

        // Send messages
        while (true) {
            String message = sc.nextLine();
            out.println(message);
        }
    }
}
