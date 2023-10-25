package fcu.edu.weber;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer implements Runnable {
    private final int portNumber = 6789;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    public Socket getClientSocket(){
        return this.clientSocket;
    }

    private static HttpRequest httpRequest;
    public static HttpRequest getHttpRequest(){
        return httpRequest;
    }

   public void createWebServer() throws IOException {
        serverSocket = new ServerSocket(portNumber);
        System.out.println("ServerSocket is been build.\n");

        if(!serverSocket.isClosed()){
            while(true){
                try {
                    clientSocket = serverSocket.accept();
                    System.out.println("Connect successfully IP : " + clientSocket.getInetAddress() +
                            " Port Number : " + clientSocket.getPort());
                } catch (IOException e) {
                    System.out.println("ERROR : " + e);
                }
            }
        }else{
            System.out.println("Server Socket is closed.");
        }

   }

    public void run() {
        try {
            createWebServer();
            httpRequest = new HttpRequest(clientSocket);
            Thread thread = new Thread(httpRequest);
            thread.start();

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }
}
