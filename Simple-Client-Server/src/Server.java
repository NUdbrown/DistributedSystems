import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.hallaLib.HallaStor;

public class Server implements Runnable {

	
	public static void main(String[]args){
		Server s = new Server();
		s.run();
	}
	
	public void run(){
		
		try {
			ServerSocket ss = new ServerSocket(3000);
			while(true){
				Socket clientSocket = ss.accept();
				
				//a switch to determine actions based on inputs
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public HallaStor getStore() {
		return HallaStor.getInstance();
	}


}
