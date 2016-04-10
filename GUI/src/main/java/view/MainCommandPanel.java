package view;

import static view.LayoutHelper.createConnectionLayout;
import static view.LayoutHelper.createLinesGridLayout;
import static view.LayoutHelper.createWaitingList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainCommandPanel {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(2000, 2000);

		createConnectionLayout(shell);	
		createLinesGridLayout(shell);		
		createWaitingList(shell);
		
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
