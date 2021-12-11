import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = serverSocket.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // todo: implement the scenario
        String msg = inServer.readLine();
        String newMsg = "";
        for (int i=0;i<msg.length();i++){
            if (Character.toUpperCase(msg.charAt(i)) == 'A' ||
                    Character.toUpperCase(msg.charAt(i)) == 'O' ||
                    Character.toUpperCase(msg.charAt(i)) == 'I' ||
                    Character.toUpperCase(msg.charAt(i)) == 'U' ||
                    Character.toUpperCase(msg.charAt(i)) == 'Y' ||
                    Character.toUpperCase(msg.charAt(i)) == 'E'  ){
                continue;
            }
            newMsg  = newMsg+msg.charAt(i);
        }
        outServer.println(newMsg);

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
        serverSocket.close();
    }
}
