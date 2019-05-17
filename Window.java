import java.awt.Container;
import javax.swing.JFrame;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public Window() {
		setTitle("Let's Rush Out");
		MyPanel panel = new MyPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		pack();
	}

	public static void main(String[] args) {
		Window e1 = new Window();
		e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		e1.setVisible(true);
		e1.setLocationRelativeTo(null);
		e1.setResizable(false);
	}
}
