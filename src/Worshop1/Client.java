package Worshop1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static int port=6600;
    public static void main(String[] args) throws IOException {
        System.out.println("\\Simple Client");
        System.out.println("\t\t==============================\n\n");

        InetAddress ipAddress=InetAddress.getLocalHost();//getLocalHost is used beacuse client and server in the same computer

        Socket socket=new Socket(ipAddress,port);//Creating client socket

        System.out.println("Server is connected...\n\n");

        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //'in' is  data coming from server
        String input=in.readLine();

        System.out.println("Server says:"+input);
        System.out.println("Closing connection....");
        socket.close();
        in.close();
        System.exit(0);//this is not necessary
    }
}
