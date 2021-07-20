package chatClient;
import java.net.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Socket socket = null;
        try {
            socket = new Socket("219.248.214.226", 9001);
            Thread thread1 = new SenderThread(socket,args[0]);
            Thread thread2 = new ReceiverThread(socket);
            thread1.start();
            thread2.start();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

	}

}
