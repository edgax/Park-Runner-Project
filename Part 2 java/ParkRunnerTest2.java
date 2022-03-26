import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkRunnerTest2
	{
		public static void main ( String[] args)throws Exception // lear this line by heart
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

			Scanner fileScanIn = new Scanner(new File("RunnerData.txt"));
			numberOfRunnner = Integer.parseInt(fileScanIn.nextLine());
			System.out.printf("RunnerDate %d \n", numberOfRunnner);

			ParkRunner[] myRunner = new ParkRunner[numberOfRunnner];

			for (int i = 0; i < numberOfRunnner ; i++)
			{
				myRunner[i] = new ParkRunner();
				name = fileScanIn.nextLine();
				year = Integer.parseInt(fileScanIn.nextLine());
				month = Integer.parseInt(fileScanIn.nextLine());
				day = Integer.parseInt(fileScanIn.nextLine());
				gender = fileScanIn.nextLine();
				barcode = myRunner[i].genBarcode(i+1);
				age = myRunner[i].setAge(year,month,day);
				//age = myRunner[i].getAge();
				//myRunner[i].setName(fileScanIn.nextLine());
				//myRunner[i].setAge(Integer.parseInt(fileScanIn.nextLine()),
									//Integer.parseInt(fileScanIn.nextLine()),
									//Integer.parseInt(fileScanIn.nextLine()));

				//myRunner[i].setGender(fileScanIn.nextLine());
				myRunner[i] = new ParkRunner(name,gender,age,barcode);
				numberofParkRuns = Integer.parseInt(fileScanIn.nextLine());

				myRunner[i].setNumberOfRuns(numberofParkRuns);



				String parkName;
				double parkRunTime;
				//myRunner[i].setRecordNewRun(parkName,parkRunTime);

				System.out.println("Barcode= " +myRunner[i].getBarcode());
				System.out.println("name= " +myRunner[i].getName());
				System.out.println("Age= " +myRunner[i].getAge());
				System.out.println("gender=  " +myRunner[i].getGender());
				System.out.println("RunnerLaps= "+ myRunner[i].getNumberOfRuns());


				for ( int j = 0 ; j < numberofParkRuns; j++)
				{
					parkName = (fileScanIn.nextLine());
					//System.out.println("parkName= " +parkName);
					parkRunTime = Double.parseDouble(fileScanIn.nextLine());
					//System.out.println("runTime= " +parkRunTime);
					myRunner[i].setRecordNewRun(parkName, parkRunTime,j);
				}

				parkNamedisplay = myRunner[i].getParkName();
				parkRunDisplay = myRunner[i].getRunTime();

				for (int k = 0; k < myRunner[i].getNumberOfRuns() ; k++) {
				System.out.printf("ParkName: %s \n" , parkNamedisplay[k]);
				System.out.printf("runTime: %.2f \n" , parkRunDisplay[k]);
				}

				System.out.println("Average= "+myRunner[i].findAverage2());
				System.out.println("Fastest= "+myRunner[i].findFastest2());
				System.out.println("Slowest= "+myRunner[i].findSlowest2());


			}

			PrintStream fileOut = new PrintStream(new File("RunnerDataOut.txt"));
			for(int k = 0; k < numberOfRunnner ; k++)
			{
				fileOut.println("Barcode = " + myRunner[k].getBarcode());
				fileOut.println("Name: "+myRunner[k].getName());
				fileOut.println("Gender: "+myRunner[k].getAge());
				fileOut.println("Number of Runs = " +myRunner[k].getNumberOfRuns());

				parkNamedisplay = myRunner[k].getParkName();
				parkRunDisplay = myRunner[k].getRunTime();
				for (int i = 0; i < myRunner[k].getNumberOfRuns() ; i++) {
					fileOut.printf("ParkName: %s \n" ,parkNamedisplay[i]);
					fileOut.println();
					fileOut.printf("runTime: %.2f \n" , parkRunDisplay[i]);
					fileOut.println();
				}
				fileOut.println("Average runs= "+myRunner[k].findAverage2());
				fileOut.println("Fastest runs= "+myRunner[k].findFastest2());
				fileOut.println("Slowest runs= "+myRunner[k].findSlowest2());
				//fileOut.println(myRunner[k].recordNewRunDisplay2());
			}

		 }
	}/*	//Ask User to input their name
			System.out.println("Please Enter your name");
			name = scan1.nextLine();

			//Reading user input
			System.out.println("Please Enter your Date of Birth");
			System.out.println("Please Enter your Year");
			int year = scan1.nextInt();
			System.out.println("Please Enter your Month");
			int month = scan2.nextInt();
			System.out.println("Please Enter your day");
			int day = scan1.nextInt();

			// Please enter your Gender
			System.out.println("Please Enter you Gender ");
			gender = scan1.next().charAt(0);

			ParkRunner Ru1 = new ParkRunner();
			Ru1.setAge(year, month, day);
			Ru1.setGender(gender);
			Ru1.setName((name));
			Ru1.recordNewRun();

			System.out.printf("The runner name is %s \n Gender is %c \n The Runner age is %d \n user baracode %s \n", Ru1.getName(),Ru1.getGender(),Ru1.getAge(),Ru1.getbarcode());
			Ru1.recordNewRunDisplay();
			Ru1.findFastest();
			Ru1.findAverage();
			Ru1.FindSlowest();
 */




