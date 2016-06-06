package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static ServerSocket ssocket;
	
	public static void main(String[] args) throws IOException {
		ssocket = new ServerSocket(8080);		
		while(true) {
			Socket sk = ssocket.accept();			
			new RequestHandler(sk).start();											
		}
	}
}
