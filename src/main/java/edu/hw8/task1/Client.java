package edu.hw8.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Enter a keyword (or 'exit' to quit): ");
                String keyword = scanner.nextLine();

                if ("exit".equalsIgnoreCase(keyword)) {
                    break;
                }

                sendRequest(socket, keyword);
                String response = receiveResponse(socket);
                System.out.println("Server response: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendRequest(Socket socket, String keyword) throws IOException {
        try (OutputStream outputStream = socket.getOutputStream()) {
            outputStream.write(keyword.getBytes());
        }
    }

    private static String receiveResponse(Socket socket) throws IOException {
        try (InputStream inputStream = socket.getInputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            return new String(buffer, 0, bytesRead);
        }
    }
}
