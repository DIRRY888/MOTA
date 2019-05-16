package interfaces;

import javax.swing.JDialog;

public class MyJDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	public MyJDialog(Main_interface frame) {
		super(frame, "Start Game", true);
		//Container container = getContentPane();
		setBounds(120,120,100,100);
	}
}
