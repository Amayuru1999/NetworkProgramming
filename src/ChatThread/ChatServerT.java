package ChatThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerT {


    static int port=7744;
    public static void main(String[] args) throws IOException {
        System.out.println("\t\t Chat Server");
        System.out.println("\t\t=======================\n\n");

        ServerSocket serversocket=new ServerSocket(port);
        int current_clients=1;

        Scanner ScannerInput=new Scanner(System.in);

        String input,output;
        try {
            while (true) {
                Socket client = serversocket.accept();
                System.out.println("Client is connected.....\n\n");
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in =new BufferedReader(new InputStreamReader(client.getInputStream()));

                try {
                    out.println("Welcome to Chat Application");
                    while (true){
                        input=in.readLine();
                        System.out.println("Client Says: "+input);

                        System.out.println("Server: ");
                        output=ScannerInput.nextLine();
                        out.println(output);
                    }
                } finally {
                    client.close();
                    out.close();
                    in.close();
                }
            }
        }finally {
            serversocket.close();//when the client is terminated
        }
    }
}
