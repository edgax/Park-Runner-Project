import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkRunnerTest1
	{
		public static void main ( String[] args)throws Exception // lear this line by heart
		{
			String Barcode;
			String name;
			String gender;
			int NumberOfRuns;

			Scanner scan1 = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
			Scanner scan3 = new Scanner(System.in);

			//Ask User to input their name
			System.out.println("Please Enter your name");
			name = scan1.nextLine();

			//Reading user input
			System.out.println("Please Enter your Date of Birth");
			System.out.println("");
			System.out.println("Please Enter your Year");
			int year = scan1.nextInt();
			System.out.println("Please Enter your Month");
			int month = scan2.nextInt();
			System.out.println("Please Enter your day");
			int day = scan1.nextInt();

			// Please enter your Gender
			System.out.println("Please Enter you Gender");
			gender = scan3.nextLine();

			ParkRunner Ru1 = new ParkRunner();
			Ru1.setAge(year, month, day);
			Ru1.setGender(gender);
			Ru1.setName((name));
			Ru1.recordNewRun();

			System.out.printf("The runner name is %s \n Gender is %s \n The Runner age is %d \n user baracode %s \n", Ru1.getName(),Ru1.getGender(),Ru1.getAge(),Ru1.getBarcode());
			Ru1.recordNewRunDisplay();
			Ru1.findFastest();
			Ru1.findAverage();
			Ru1.FindSlowest();




		}
}