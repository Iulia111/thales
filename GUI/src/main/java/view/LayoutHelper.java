package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import handlers.ConnectionHandler;

public class LayoutHelper {
	public static void createConnectionLayout(Shell shell) {
		GridLayout layout = new GridLayout(2, false);
		shell.setLayout(layout);

		final Label connectLabel = new Label(shell, SWT.BORDER);
		connectLabel.setText("Not connected to CORE");
		Button button = new Button(shell, SWT.PUSH);
		button.setText("Connect to the CORE");
		
		button.addSelectionListener(new ConnectionHandler(connectLabel));
	}
	
	public static void createLinesGridLayout(Shell shell) {
		GridLayout lines = new GridLayout(2, false);
		final Label line1 = new Label(shell, SWT.BORDER);
		line1.setText("Line 1: free");
		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Go to 1");
		final Label line2 = new Label(shell, SWT.BORDER);
		line2.setText("Line 2: free");
		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("Go to 2");
		final Label line3 = new Label(shell, SWT.BORDER);
		line3.setText("Line 3: free");
		Button button3 = new Button(shell, SWT.PUSH);
		button3.setText("Go to 3");
		shell.setLayout(lines);
	}
	
	public static void createWaitingList(Shell shell) {
		GridLayout listLayout = new GridLayout(2, false);
		shell.setLayout(listLayout);
		
		Label label = new Label(shell, SWT.BORDER);
		label.setText("Waiting list");
		final List list = new List(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);

	    for (int loopIndex = 0; loopIndex < 4; loopIndex++) {
	      list.add("Item " + loopIndex);
	    }
	}

}
