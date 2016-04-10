package server;

import java.net.*;
import org.apache.log4j.Logger;
import java.io.*;

public class CoreServer extends Thread {
	private static Logger LOGGER = Logger.getLogger(CoreServer.class);
	private ServerSocket serverSocket;

	public CoreServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	public void run() {
		while (true) {
			try {
				LOGGER.info("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				LOGGER.info("Connection accepted from " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				LOGGER.info(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
				server.close();
			} catch (SocketTimeoutException s) {
				LOGGER.info("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		int port = 6066;
		try {
			Thread t = new CoreServer(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}