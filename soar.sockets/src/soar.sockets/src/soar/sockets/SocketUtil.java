package soar.sockets;

import java.net.Socket;

public class SocketUtil {
	
	public static String read(Socket socket) throws Exception {
		byte[] bytes = new byte[100];
		socket.getInputStream().read(bytes);
		return new String(bytes).trim();
	}
	
	public static void write(Socket socket, String message) throws Exception {
		socket.getOutputStream().write(message.getBytes());
		socket.getOutputStream().flush();
	}
}
