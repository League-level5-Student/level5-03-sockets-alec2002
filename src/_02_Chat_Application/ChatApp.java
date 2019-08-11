package _02_Chat_Application;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import _00_Click_Chat.gui.ButtonClicker;
import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

public class ChatApp {
	
	ChatAppServer server;
	ChatAppClient client;
	
	public static void main(String[] args) {
		new ChatApp();
	}
	
	public ChatApp(){

		int response = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "Buttons!", JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION){
			server = new ChatAppServer(8080);
			JOptionPane.showMessageDialog(null, "Server started at: " + server.getIPAddress() + "\nPort: " + server.getPort());
			String message = JOptionPane.showInputDialog("Type your message");
			
			server.sendMessage(message);
			
			server.start();
			
		}else{
			String ipStr = JOptionPane.showInputDialog("Enter the IP Address");
			String prtStr = JOptionPane.showInputDialog("Enter the port number");
			int port = Integer.parseInt(prtStr);
			client = new ChatAppClient(ipStr, port);
			
			String message = JOptionPane.showInputDialog("Type your message");

			client.sendMessage(message);
	
			client.start();
		}
	}
}

	

