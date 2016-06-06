package server;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RequestHandler extends Thread{
	private Socket sk;

	public RequestHandler(Socket sk) {
		this.sk = sk;
	}
	public void run() {
		byte[] data;
		try {
			data = new byte[sk.getInputStream().available()];
			sk.getInputStream().read(data, 0, data.length);
			String[] data2 = new String(data, "UTF-8").split("\n");
			System.out.println("Server Received: " + data2[data2.length - 1]);
			sendResponse(compiler.Navigator.NAVQDSL(data2[data2.length - 1]));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendResponse(String json) throws IOException {
		DataOutputStream outToClient = new DataOutputStream(sk.getOutputStream());
		outToClient.writeBytes(getHTTP(json));
		sk.close();
	}

	private String getHTTP(String data) {
		String c = new String("HTTP/1.1 200 OK\r\n"
				+ "Access-Control-Allow-Origin: *\r\n"
				+ "Content-Length: " + data.length() + "\r\n"
				+ "Connection: Close\r\n"
				+ "Content-Type: application/json\r\n"
				+ "\r\n"
				+ data + "\r\n");
		return c;
	}

}
