import java.io.*;
import java.net.*;


/**
 * Write a description of class WebClient here.
 * 
 * @author Mohammed Sahil   
 */
public class WebClient {
    public static void main(String[] args) throws Exception {
        String html;
        URL url = new URL("https://imgs.xkcd.com/comics/devotion_to_duty.png");
        /* Once you open the connection to URL object, beneath it a client socket gets connected to server */
        /* and send all the http request headers derived from the URL are sent via the socket. */
        
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        InputStream fromServer = urlConnection.getInputStream();
        byte[] data = new byte[100];
        int count;

        String fileName = "C:\\Users\\admin\\Documents\\f2014010\\Lab_4\\bits_gif.png";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);

        while((count = fromServer.read(data)) != -1) {
            fileOutputStream.write(data, 0, count);
        }
        fileOutputStream.flush();
        fileOutputStream.close();

        fromServer.close();
    }
}
