
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.net.Socket;
import java.net.SocketException;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class ParkRunnerTest3Client {
	public static void main(String[] args) throws IOException, SocketException// lear this line by heart
	{
		String barcode;
		String name;
		String gender;
		int numberOfRunnner;
		int numberofParkRuns;
		int number;
		String parkNamedisplay[];
		double parkRunDisplay[];
		int year = 0;
		int month = 0;
		int day = 0;
		long age = 0;
		int t = 1;
		try {

			Socket clientSock = new Socket("localhost", 5001);

			ObjectOutputStream objectOut = new ObjectOutputStream(clientSock.getOutputStream());

			Scanner fileScanIn = new Scanner(new File("RunnerData.txt"));
			numberOfRunnner = Integer.parseInt(fileScanIn.nextLine());

			ParkRunner[] myRunner = new ParkRunner[numberOfRunnner];


			for (int i = 0; i < numberOfRunnner; i++) {
				name = fileScanIn.nextLine();
				year = Integer.parseInt(fileScanIn.nextLine());
				month = Integer.parseInt(fileScanIn.nextLine());
				day = Integer.parseInt(fileScanIn.nextLine());
				gender = fileScanIn.nextLine();

				age = getAge(year, month, day);
				barcode = genBarcode(t++);

				myRunner[i] = new ParkRunner(name, gender, age, barcode);

				numberofParkRuns = Integer.parseInt(fileScanIn.nextLine());

				myRunner[i].setNumberOfRuns(numberofParkRuns);


				String parkName;
				double parkRunTime;
				//myRunner[i].setRecordNewRun(parkName,parkRunTime);


				for (int j = 0; j < numberofParkRuns; j++) {
					parkName = (fileScanIn.nextLine());
					//System.out.println("parkName= " +parkName);
					parkRunTime = Double.parseDouble(fileScanIn.nextLine());
					//System.out.println("runTime= " +parkRunTime);
					myRunner[i].setRecordNewRun(parkName, parkRunTime, j);
				}


			}
			objectOut.writeObject(myRunner);

			objectOut.close();
			clientSock.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}


	private static String genBarcode(int number) {
		String barcode;
		String result = "A";
		int n = String.valueOf(number).length();
		for (int i = 0; i < 7 - n; i++) {
			result += "0";
		}
		result += String.valueOf(number);
		barcode = result;
		return barcode;
	}


	public static long getAge(int year, int month, int date) //  this method is to set the age
	{
		long age;
		LocalDate currentDate = LocalDate.now();
		LocalDate BirthDate = LocalDate.of(year, month, date);
		age = ChronoUnit.YEARS.between(BirthDate, currentDate);
		return age;
	}

}





