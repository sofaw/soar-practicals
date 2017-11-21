package soar.sockets;

import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws Exception {
		new Client().run();
	}
	
	private void run() throws Exception {
		Socket socket = 
				new Socket(InetAddress.getLocalHost(), 8000);
		SocketUtil.write(socket, "YO10 5AW");
		System.out.println(SocketUtil.read(socket));
		socket.close();
	}
	
}
