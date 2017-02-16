import java.net.*;
import java.io.*;

/**
 * A multi-threaded TCP Server
 * 
 * @author Mohammed Sahil
 * @version 0.0.1
 */
public class MultiThreadedServer implements Runnable {

    // Will get created whenever we create an obj of MuliThreadServer for each client thread
    // Available to each thread
    Socket clientSocket;     
    int clientID;
    static int clientCount = 0;

    public MultiThreadedServer(Socket connection) {
        clientSocket = connection;
        clientCount++;
        clientID = clientCount;
    }
    /**
     * Create a ServerSocket via port# 6789 and wait for connections from client
     * Hence the server application will be assigned to address 6789
     */
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6789);
        } catch (IOException e) {
            System.err.println("Could not listen on port 6789");
            System.exit(1);
        }

        /* Server waits for connection from Client. Server should start a thread to serve every client */
        System.out.println("Waiting for connection........");
        Socket clientSocket = null;
        while(true) {
            try {
                clientSocket = serverSocket.accept();       // Also called connection socket
            } catch (IOException e) {
                System.err.println("Accept failed");
                System.exit(1);
            }
            System.out.println("Connection successful");
            System.out.println("Waiting for input");

            MultiThreadedServer multiThreadedServer = new MultiThreadedServer(clientSocket);
            Thread clientThread = new Thread(multiThreadedServer);
            clientThread.start();     // Thread for serving a client
        }
    }

    @Override
    public void run() {
        /**
         * 1) Attach input stream and output stream to connection socket (clientSocket) 
         * 2) Wait for input from client
         * 3) Once input is got, convert lowercase to uppercase
         * 4) Send uppercase data to client 
         */
        BufferedReader in = null;
        PrintWriter out = null;

        while(true) {
            try 
                {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));   // From Client
                    out = new PrintWriter(clientSocket.getOutputStream(), true);                        // To Client
                    String inp_str = in.readLine();
                    String out_str = inp_str.toUpperCase();
                    System.out.println(clientID + ": " + inp_str);
                    out.println(out_str);
                    out.println("Your clientID is " + clientID);
                    out.println();
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
        
        }
    }
}
