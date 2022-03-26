
import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class ParkRunner
{
	private String barcode = this.genBarcode(1);
	private	String name;
	private String gender;
	private long age;
	private String[] park = new String[5];
	private float[] fivekmruntimes = new float[5];
	private double sum;
	private int numberOfRun;

	Scanner scan2 = new Scanner(System.in);
	Scanner scan1 = new Scanner(System.in);

public ParkRunner(String name,String gender, long age,String barcode)
{

	this.name = name;
	this.gender = gender;
	this.age = age;
	this.barcode = barcode;
}
public ParkRunner()
{

}
public void setName(String name)
{

	this.name = name;
}
public void setGender(String gender)
{

	this.gender = gender;
}

public void recordNewRun() // asking for the runner to input their parkname and run time
{
	for(int i = 0; i< 5; i++)
	{
		System.out.println("Please enter your Park");
		park [i]= scan2.nextLine();

		System.out.println("Please enter your RunTime");
		fivekmruntimes [i] = scan1.nextFloat();


	}

}


	public void recordNewRunDisplay() // display the user run time input
{
for (int i = 0; i < 5 ; i++)
	{
		System.out.println("Park: \n"+park[i]);

		System.out.println("RunnerTime: \n"+fivekmruntimes[i]);
	}

}



	public void findAverage() // finding the average run of the runner

	{
		int n = 0;
		float sum = 0;
		float average = 0;
		for (int i=0; i<5; i++) {
			sum = sum + fivekmruntimes[i];
		}

		average = sum/5;
		System.out.printf("The Average time for this runner is: %.2f \n" ,average);
	}

	public void findFastest() // This method is finding the fast speed in the runner
	{
		double fastest = fivekmruntimes [0];

		for (int i = 1; i < fivekmruntimes.length; i++)
		{
			if (fivekmruntimes[i] < fastest)
			{
				fastest = fivekmruntimes[i];
			}
		}

		System.out.printf("The Fastest time for this runner is: %.2f \n"  ,fastest);
	}



	public void  FindSlowest() {
		double slowest = fivekmruntimes [0];
		for (int i = 1; i < fivekmruntimes.length; i++) {
			if (fivekmruntimes[i] > slowest)
			{
				slowest = fivekmruntimes[i];
			}
		}
		System.out.printf("The slowest time for this runner is: %.2f \n"  ,slowest);
	}

public long setAge(int year, int month , int date) //  this method is to set the age
{
	LocalDate currentDate = LocalDate.now();
	LocalDate BirthDate = LocalDate.of(year, month, date);
	this.age = ChronoUnit.YEARS.between(BirthDate,currentDate);
	return this.age;
}
public String getName()
{
	return this.name;
}

public String genBarcode(int number)
{
	String result = "A";
	int n = String.valueOf(number).length();
	for  (int i = 0; i < 7 - n; i++)
		{
		result += "0";
		}
	result += String.valueOf(number);
	this.barcode = result;
	return this.barcode;
}



public long getAge()

{
	return this.age;
}

public String getGender()
{

	return this.gender;
}
public int getNumberOfRuns()
{
	return this.numberOfRun;
}
public void setNumberOfRuns(int numberOfRun)
	{
		this.numberOfRun = numberOfRun;
	}

	public String getBarcode()
	{

		return this.barcode;
	}
}





