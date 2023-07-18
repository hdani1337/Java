package g3051a_kliensSzerver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	public static boolean prim(int x)
	{
		int i = 2 ;
		while(i < x)
		{
			if (x % i == 0)
			{
				return true ;
			}
			i++ ;
		}
		return false ;
	}
	public class MyThread implements Runnable
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
						System.out.println("Kliens üzenete: "+line)	;			
						System.out.println("Sending:" + Cesar.code(line, 10));
						out.println(Cesar.code(line, 10));
					}
				}
			}
			catch(Exception exc)
			{
				System.out.println(exc);
			}
		}	
	}
	public static ServerSocket 		server 			;
	public static Socket 			client 			;
	public static PrintWriter 		out 			;
	public static BufferedReader 	in 				;
	public static boolean 			exit 	= false	;
	public static void main(String[] args)
	{
		try
		{
			System.out.println("---SZERVER---");
			server = new ServerSocket(4999);
			System.out.println("Waiting for client");
			client = server.accept();
			System.out.println("Client connected");
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			Thread thread = new Thread(new Server().new MyThread());
			thread.start();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}		
	}

}