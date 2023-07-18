package g3051a_kliensSzerver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
	class MyThread implements Runnable
	{

		@Override
		public void run()
		{
			String line = null ;
			try
			{
				while(true)
				{
					while((line = in.readLine()) != null)
					{
						System.out.println("Szerver üzenete: " + line);
					}
				}
			}
			catch(Exception exc)
			{
				System.out.println(exc);
			}
		}	
	}
	public static Socket 			client 			;
	public static PrintWriter 		out 			;
	public static BufferedReader 	in 				;
	public static void main(String[] args)
	{
		try
		{
			System.out.println("---KLIENS---");
			client = new Socket("127.0.0.1",4999) 					; 
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			Thread thread = new Thread(new Client().new MyThread()) 	;
			thread.start()	;
			out.println("Megszentsegtelenithetetlensegeskedeseitekert");
			out.flush();
			System.out.println("Sending: Megszentsegtelenithetetlensegeskedeseitekert");
			//szöveg bekérése, szervernek elküldeni, szerver megfordítja, visszaküldi
			
			String input = "";
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			out.println(input);
			out.flush();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}				

	}

}