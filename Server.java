package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket  ss = new ServerSocket(8888);
		Socket client = ss.accept();
		System.out.println(client.getInetAddress()+" is coming!");
		PrintStream ps = new PrintStream(client.getOutputStream());
		BufferedReader rd  = new BufferedReader(new InputStreamReader(client.getInputStream()) );
		while(true){
			ps.println(rd.readLine().toUpperCase());
			if(rd.readLine().equals("over")) {
				client.close();
				ps.close();
				rd.close();
				System.out.println(client.getInetAddress()+" is out !");
			}
			if(rd.readLine().equals("allover")){
				client.close();
				ps.close();
				rd.close();
				ss.close();
				System.out.println(client.getInetAddress()+" is out !");
			}
		}
	
	}

}
