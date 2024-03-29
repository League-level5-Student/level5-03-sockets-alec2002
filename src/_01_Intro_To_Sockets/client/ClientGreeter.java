package _01_Intro_To_Sockets.client;

import java.net.*;
import java.io.*;

public class ClientGreeter {

	public static void main(String[] args) {
		// 1. Create a String for the ip address of the server.
		// If you don't know how to find a computer's ip address, ask about ifconfig on
		// linux/mac and ipconfig on windows.

		String IPad = "192.168.1.176.";

		// 2. Create an integer for the server's port number

		int port = 8080;

		// 3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
		try {

			// 4. Create an object of the Socket class. When initializing the object, pass
			// in the ip address and the port number
			
			Socket sock = new Socket(IPad, port);
			
			// 5. Create a DataOutputStream object. When initializing it, use the Socket
			// object you created in step 4 to call the getOutputStream() method.
			
			DataOutputStream Datout = (DataOutputStream) sock.getOutputStream();
			
			// 6. Use the DataOutputStream object to send a message to the server using the
			// writeUTF(String message) method
			
			Datout.writeUTF("Hello");

			// 7. Create a DataInputStream object. When initializing it, use the Server
			// object you created in step 4 to call the getInputStream() method.
			
			DataInputStream Datin = (DataInputStream) sock.getInputStream();

			// 8. Use the DataInputStream object to print a message from the server using
			// the readUTF() method.
			
			Datin.readUTF();

			// 9. Close the client's server object
			
			sock.close();

		} catch (Exception e) {
			System.out.println("Didn't work");
		}

	}
}
