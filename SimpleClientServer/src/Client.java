import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;

public class Client {
	private Random random;
	private ArrayList<String> listOfObjects = new ArrayList<String>();
	
	public static void main(String[] args) {
		Client c = new Client();
		c.run();
	}

	public void run() {
		random = new Random();
		try {
			for (int i = 1; i <= 25; i++) {
				Socket s = new Socket("localhost", 3030);
				DataOutputStream output = new DataOutputStream(s.getOutputStream());
				DataInputStream input = new DataInputStream(s.getInputStream());
				// random decision car or driver
				int choiceOfObj = random.nextInt(2);
				// write operation
				output.writeByte(1);
				output.flush();
				// set up car or driver
				if (choiceOfObj == 0) {
					output.write(0);
					writeRacecar(createCar(), output);
				} else {
					output.write(1);
					writeDriver(createDriver(), output);
				}
				// write data wanting to send

				int returnMsg = input.readInt();
				if (returnMsg == 5) {
					System.out.println(returnMsg + "\ncount at " + i);
					String keyOfItem = input.readUTF();
					listOfObjects.add(keyOfItem);
					System.out.println("Ive add the new key and Im done!");
					output.writeUTF("done");
					output.flush();
					//close everything
					output.close();
					input.close();
					s.close();
					printList();
				}

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void printList() {
		int index = 1;
		for(String item : listOfObjects){			
			System.out.println(index + ": " + item);
			index++;
		}
		
	}

	private Racecar createCar() {
		return new Racecar(generateId(), "BMW", "SLXR",
				generateHorsePower(), generateQuarterMileTime());
	}

	private Driver createDriver() {
		int index = 0;
		boolean isMale;
		String name = "";
		if (random.nextBoolean() == false) {
			name = "DanTheMan";
			isMale = true;
		} else {
			name = "SherlTheGirl";
			isMale = false;
		}
		return new Driver(generateId(), name + index++,
				generateAge(), random.nextBoolean());
	}

	// writing
	public void writeRacecar(Racecar car, DataOutputStream out) throws IOException {
		System.out.println("sending car info");
		// send car id
		out.writeInt(car.getId());
		out.flush();
		// send make		
		out.writeUTF(car.getMake());
		out.flush();
		// send model
		out.writeUTF(car.getModel());
		out.flush();
		// send horsepower
		out.writeInt(car.getHorsePower());
		out.flush();
		// send quarter-mile
		out.writeDouble(car.getQuarterMileTime());
		out.flush();
		System.out.println("sent all of car info");

	}

	public void writeDriver(Driver d, DataOutputStream out) throws IOException {
		System.out.println("sending all of driver info");
		// send id
		out.writeInt(d.getId());
		out.flush();
		// send Name
		out.writeUTF(d.getName());
		out.flush();
		// send age
		out.writeInt(d.getAge());
		out.flush();
		// send isMale
		out.writeBoolean(d.isMale());
		out.flush();
		System.out.println("sent all of driver");
	}

	private int generateQuarterMileTime() {
		return random.nextInt(5) + 1;
	}

	private int generateHorsePower() {
		return random.nextInt(1500) + 1;
	}

	private int generateId() {
		return random.nextInt(200);
	}
	
	private int generateAge(){
		int max = 55;
		int min = 25;
		return  random.nextInt((max - min) + 1) + min;
	}

	public ArrayList<String> getListOfObjects() {
		return listOfObjects;
	}

}
