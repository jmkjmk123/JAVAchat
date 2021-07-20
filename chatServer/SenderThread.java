package chatServer;
import java.io.*;
import java.util.*;
import java.net.*;
public class SenderThread extends Thread {
	static List<PrintWriter> list= Collections.synchronizedList(new ArrayList<PrintWriter>());
	Socket socket;
	PrintWriter writer;
    SenderThread(Socket socket) {   
        this.socket = socket;
        try{
        	writer = new PrintWriter(socket.getOutputStream());
        	list.add(writer);
        }
        catch (Exception e){
        	System.out.println(e.getMessage());
        }
    }
    public void run() {
 
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
            while (true) {
                String str = reader.readLine();
                if (str.equals("end"))
                    break;
                sendAll("Server"+">"+str);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }   
        finally {
        	list.remove(writer);
            try {
                socket.close();
            }
            catch (Exception ignored) {
            }
        }
    }
    private void sendAll(String str){
        for(PrintWriter writer :list){
        writer.println(str);
        writer.flush();
        }
    }

}
