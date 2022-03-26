
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class ParkRunner implements Serializable
{
	//private static final long serialVersionUID = 6448478812358248907L;
	private String barcode = this.genBarcode(1);

	private	String name;
	private String gender;
	private long age;
	private int numberOfRun;
	private double[] runTime = new double[99];
	private String[] parkName = new String[99];

public ParkRunner(String name,String gender,long age,String barcode)
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






	public void setRecordNewRun(String parkName, double runTime,int j)
	{
		for (int k = 0; k < numberOfRun; k++) ;
		{

			this.parkName[j] = parkName;
			this.runTime[j] = runTime;

		}

	}


	public String[] getParkName()
	{
		return this.parkName;
	}
	public double[] getRunTime()
	{
		return this.runTime;
	}


	public double findAverage2()

	{

		double sum = 0;
		double average = 0;
		for (int i=0; i<numberOfRun; i++) {
			sum = sum + runTime[i];
		}

		return average = sum/5;
		//System.out.printf("The Average time for this runner is: %f0.2 \n" ,average);
	}

	public double findSlowest()
	{
		double slowest = runTime[0];
		for (int i = 1; i < numberOfRun; i++)
		{
			if (runTime[i] > slowest)
			{
				slowest = runTime[i];
				// not here: System.out.println("The highest maximum for the December is: " + max);
			}
		}
		//System.out.printf("The Fastest time for this runner is: %f \n"  ,slowest);
		return slowest;
	}

	public double  findFastest()
	{
		double fastest = runTime[0];
		for (int i = 1; i < numberOfRun; i++)
		{
			if (runTime[i] < fastest)
			{
				fastest = runTime[i];
			}
		}
		return fastest;
		//System.out.printf("The slowest time for this runner is: %f.2 \n"  ,fastest);
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





