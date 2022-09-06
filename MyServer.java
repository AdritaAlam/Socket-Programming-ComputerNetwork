import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Successfully server has started at port 6666");
            Socket s = ss.accept();//Connection establish
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String)dis.readUTF();
            System.out.println("Message = " + str);
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Connection Closed");
    }
}