package conection;

import java.net.*;

import org.apache.log4j.Logger;

import java.io.*;

public class GuiConnection {
	private static Logger LOGGER = Logger.getLogger(GuiConnection.class);
	
	public static boolean connectCore(String serverName, Integer port) {
		boolean isConnected = false;
		try {
			Socket client = new Socket(serverName, port);
			LOGGER.info("Connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			LOGGER.info("Server says " + in.readUTF());
			isConnected = true;
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isConnected;
	}
}
