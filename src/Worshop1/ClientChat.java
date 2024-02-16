package Worshop1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {

    public static int port=7777;
    public static void main(String[] args) throws IOException {
        System.out.println("\\Simple Client");
        System.out.println("\t\t==============================\n\n");
        ServerSocket serversocket = new ServerSocket(port);
        Scanner ScannerInput = new Scanner(System.in);

        InetAddress ipAddress = InetAddress.getLocalHost();//getLocalHost is used beacuse client and server in the same computer

        Socket socket = new Socket(ipAddress, port);//Creating client socket

        System.out.println("Server is connected...\n\n");
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //'in' is  data coming from server

        try {
            while (true) {
                String input = in.readLine();
                System.out.println("Server Says: " + input);

                System.out.println("Client: ");
                String output = ScannerInput.nextLine();
                out.println(output);
            }
        } finally {
            socket.close();
            out.close();
            in.close();
        }

    }
}
