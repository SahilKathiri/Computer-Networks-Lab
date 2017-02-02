import java.net.*;
import java.io.*;
/**
 * Write a description of class TCPSimple here.
 * 
 * @author Mohammed Sahil
 * @version 0.0.1
 */
public class TCPSimple {
    /**
     * Create a ServerSocket via port# 6789 and wait for connections from client
     * Hence the server application will be assigned to address 6789
     */
    public static void main(String[] args) throws Exception {
        ServerSocket server_socket_obj = new ServerSocket(6789);
        
        // Listen for connection from the client
        Socket client_socket = server_socket_obj.accept();
    	
    	// client_socket is used for further comm b/w server and client
    	// Sockets being a byte oriented device, we should attach inputstream and outputstream
    	BufferedReader input_from_client = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
		PrintWriter output_to_client = new PrintWriter(client_socket.getOutputStream());

		// input <- buffered reader <-from client
		// input to uppercase -> output -> print writer -> to client
		String input_string = input_from_client.readLine();
		String output_string = input_string.toUpperCase();

		// Write to client
		output_to_client.print(output_string);
		output_to_client.flush();
    }
}
