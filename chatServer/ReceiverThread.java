package chatServer;
import java.net.*;
import java.io.*;
public class ReceiverThread extends Thread{
    Socket socket;
    ReceiverThread(Socket socket) {  
        this.socket = socket;
    }
    public void run() {
    	String name;
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            name=reader.readLine();
            System.out.println(name+" ´ÔÀÌ Á¢¼ÓÇÏ¼Ì½À´Ï´Ù.");
            while (true) {
                String str = reader.readLine();
                if (str == null)
                    break;
                System.out.println(name+">" + str);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
