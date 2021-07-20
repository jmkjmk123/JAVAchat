package chatServer;
import java.net.*;
public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ServerSocket serverSocket = null;
	        Socket socket = null;
	        try {
	            serverSocket = new ServerSocket(9001);
	            while(true){
	            socket = serverSocket.accept();
	            Thread thread1 = new SenderThread(socket);
	            Thread thread2 = new ReceiverThread(socket);
	            thread1.start();
	            thread2.start();
	            }
	        }
	        catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        finally {
	            try {
	                serverSocket.close();
	            }
	            catch (Exception ignored) {
	            }
	        }   

	}

}
