import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable {

	@Override
	public void run() {
		try {
			Socket socket = new Socket("localhost", 3000);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
	}

	public static void main(String[]args){
		Client c = new Client();
		c.run();
	}
}
