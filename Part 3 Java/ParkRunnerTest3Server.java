
import java.net.*; // for Socket, ServerSocket, and InetAddress
import java.io.*; // for IOException and Input/OutputStream
import java.io.IOException;
import java.util.*;
import java.util.Scanner;



public class ParkRunnerTest3Server  {

	public static void main(String[] args)throws IOException, ClassNotFoundException{

		// Step 1: Create a ServerSocket.
		int port = 5001;
		String RunnerMale = "";                // Declare fastestMale as a string
		String RunnerFemale = "";              // declare fastestFemale as a string
		double RunnerMaleTime = 100;
		double RunnerFemaleTime = 100;

	try{
		ServerSocket serverSock = new ServerSocket(port);
		System.out.println("Server Ready for connection port number: " + port);

		// Step 2: Wait for a connection..
		Socket clientSock = serverSock.accept();

		// Step 3: Get input and output streams.
		System.out.println("Step 3: Get object input stream.,");


		InputStream in = clientSock.getInputStream();
		ObjectInputStream objectIn = new ObjectInputStream(in);

		ParkRunner[] myRunner = (ParkRunner[]) objectIn.readObject();



		for (int i = 0; i < myRunner.length; i++)
		{

			if (myRunner[i].getNumberOfRuns() > 0)
			{

				if (myRunner[i].getGender().equals("Male") && myRunner[i].findFastest() < RunnerMaleTime)
				{
					RunnerMale = myRunner[i].getName();
					RunnerMaleTime = myRunner[i].findFastest();
				}

				else if (myRunner[i].getGender().equals("Female") && myRunner[i].findFastest() < RunnerFemaleTime)
				{
					RunnerFemale = myRunner[i].getName();
					RunnerFemaleTime = myRunner[i].findFastest();
				}
			}
		}
		//Printing out the fastest Males
		System.out.println("Fastest runtime males : " + RunnerMale);
		System.out.println("RuningTime: " + RunnerMaleTime);
		//Printing out the fastest female
		System.out.println("Fastest runtime female: " + RunnerFemale);
		System.out.println("RunTime :"	+ RunnerFemaleTime);



		// Step 5: Close connection
		objectIn.close();
		clientSock.close();

	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e){
		System.err.println(e);
	}
		}
	}






