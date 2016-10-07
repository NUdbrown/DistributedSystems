import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import com.hallaLib.HallaStor;

public class Server implements Runnable {

	private Random random = new Random();

	public static void main(String[] args) {
		Server s = new Server();
		s.run();
	}

	public void run() {

		try {
			ServerSocket ss = new ServerSocket(3000);
			while (true) {
				Socket clientSocket = ss.accept();

				BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

				String command = null;
				String key = null;
				Object objectAsVal = null;
				switch (command.toUpperCase()) {
				case "update":
					getStore().update(key, objectAsVal);
					break;
				case "add":
					getStore().add(key, objectAsVal);

					break;
				case "delete":
					getStore().delete(key);
					break;
				case "exit":
					ss.close();
					break;

				}
				// a switch to determine actions based on inputs

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public HallaStor getStore() {
		return HallaStor.getInstance();
	}

	public String generateKey(Object object) {

		return null;
	}
}
