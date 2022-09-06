import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.Base64;

public class smtpSktProgram {
    private static DataOutputStream dos;
    public static void main(String []args) throws Exception {
        int delay = 1000;
        String user = "Write your email here";
        String pw = "Write your password here";
        String username = new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pw.getBytes()));
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket soc = (SSLSocket) sslsocketfactory.createSocket("smtp.gmail.com", 465);
        final BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));

        dos = new DataOutputStream(soc.getOutputStream());
        send("EHLO smtp.gmail.com\r\n");
        Thread.sleep(delay);

        System.out.println("Server: " + br.readLine());
        System.out.println("Server: " + br.readLine());
        System.out.println("Server: " + br.readLine());
        System.out.println("Server: " + br.readLine());
        System.out.println("Server: " + br.readLine());
        System.out.println("Server: " + br.readLine());
        System.out.println("Server: " + br.readLine());
        System.out.println("Server: " + br.readLine());
        System.out.println("Server: " + br.readLine());

        send("AUTH LOGIN\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+br.readLine());

        send(username+"\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+br.readLine());

        send(password+"\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+br.readLine());

        send("MAIL FROM:<s1912276153@ru.ac.bd>\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+br.readLine());

        send("RCPT TO:<adritaalam.prima@gmail.com>\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+br.readLine());

        send("DATA\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+br.readLine());


        Thread.sleep(delay);
        send("Subject: 3Y1S2021-1912276153\r\n");


        Thread.sleep(delay);
        send("Assalamualaikum Sir.\nThis is a testing mail by using SMTP server.\nThank you.\n\n\nAdrita Alam\nRoll No: 1912276153\nSession: 2018-19\nDepartment of Computer Science and Engineering,\nUniversity of Rajshahi\r\n");


        send(".\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+br.readLine());

        send("QUIT\r\n");

    }

    private static void send(String str) throws Exception{
        dos.writeBytes(str);
        System.out.println("Client: "+str);
    }
}
