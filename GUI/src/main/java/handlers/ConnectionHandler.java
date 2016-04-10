package handlers;

import java.io.IOException;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

import conection.GuiConnection;

public class ConnectionHandler extends SelectionAdapter {
	private final Label connectLabel;

	public ConnectionHandler(Label connectLabel) {
		this.connectLabel = connectLabel;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		String serverName = "";
		Integer port = 0;
		try {
			serverName = PropertiesHandler.getInstance().getValue("serverName");
			port = Integer.valueOf(PropertiesHandler.getInstance().getValue("port"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		boolean isConnectedToCore = GuiConnection.connectCore(serverName, port);
		if (isConnectedToCore) {
			connectLabel.setText("Connected to CORE");
		} else {
			connectLabel.setText("Cannot connect to CORE");
		}
		connectLabel.getParent().layout();
	}
}