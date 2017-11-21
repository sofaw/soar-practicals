package soar.sockets;

import java.net.ServerSocket;
import java.net.Socket;

public class Provider {
	
	public static void main(String[] args) throws Exception {
		new Provider().run();
	}
	
	private void run() throws Exception {
		
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(8000);
		while (true) {
			Socket socket = serverSocket.accept();
			String input = SocketUtil.read(socket);
			if (input.equals("YO10 5AW")) {
				SocketUtil.write(socket, 
					"10 Alne Terrace, YORK | " + 
					"12 Alne Terrace, YORK ");
			}
			else {
				SocketUtil.write(socket, "Unknown postcode");
			}
			socket.getOutputStream().close();
		}
	}
	
}
