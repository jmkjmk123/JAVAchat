package chatClient;
import java.net.*;
import java.io.*;
public class ReceiverThread extends Thread{
	Socket socket;
    ReceiverThread(Socket socket) {  
        this.socket = socket;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            while (true) {
                String str = reader.readLine();
                if (str == null)
                    break;
                System.out.println(str);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
